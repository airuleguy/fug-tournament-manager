package fug.tournament.api

import grails.gorm.transactions.Transactional

@Transactional
class WinConditionService {

    def tournamentService
    def levelService
    def categoryService
    def gymnastService

    // Win conditions
    // Per Gymnast
    //      Por nivel y por categoría

    // Per team:
    //      por nivel y club
    // se toman las mismas condiciones de federado A o B

    // Per exercise:
    //      por nivel, categoría y aparato

    // A_FEDERATED:
    //      MALE: 6 ejercicios, se toman los 6

    // B_FEDERATED:
    //      FEMALE: 4 aparatos, se toman los 3 mejores

    /**
     * Returns a list of maps with following form:
     *  [gymnast: Gymnast, scores: List<Score>, total_score:[]]
     * @param tournamentId
     * @param levelId
     * @param categoryId
     * @param gender
     * @return
     */
    List<Map> rankGymnastsByScore(tournamentId, levelId, categoryId, gender) {

        def tournament = tournamentService.get(tournamentId)
        def level = levelService.get(levelId)
        def category = categoryService.get(categoryId)

        def tournamentGymnasts = Gymnast.withCriteria {
            and {
                eq("level", level)
                eq("category", category)
                eq("gender", Gender.valueOf(gender))
            }

            groupProperty "id"
        }

        tournamentGymnasts.collect { gymnast ->
            def scores = gymnast.scores.findAll { it.tournament == tournament }.sort { -it.score }.take(tournament.type.exerciseLimit)
            [gymnast: gymnast, scores: scores, total_score: scores.sum { it.score }]
        }.sort { -it.total_score }
    }
}
