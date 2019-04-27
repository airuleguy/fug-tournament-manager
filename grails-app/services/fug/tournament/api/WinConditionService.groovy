package fug.tournament.api

import grails.gorm.transactions.Transactional

@Transactional
class WinConditionService {

    def tournamentService

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
    List<Map> rankGymnastsByScoreAndLevelAndCategoryAndGender(tournament, level, category, gender) {

        def tournamentScores = Score.withCriteria {
            and {
                eq("tournament", tournament)
                gymnast {
                    eq("category", category )
                    eq("level", level)
                    eq("gender", gender)
                }
            }
        }

        if(tournamentScores.size > 0) {
            def gymnastScores = tournamentScores.groupBy { score -> score.gymnast }

            def result = gymnastScores.collect { scoresByGymnast ->
                def limitedScores = scoresByGymnast.value.sort { -it.score }.take(tournament.type.exerciseLimit)
                [gymnast: scoresByGymnast.key, scores: limitedScores, total_score: limitedScores.sum { it.score }]
            }

            result
        }
    }

    List<Map> rankGymnastsByScore(tournamentId) {

        def tournament = tournamentService.get(tournamentId)

        def levels = Level.findAll()
        def categories = Category.findAll()
        def genders = Gender.values() as List

        def rankedGymnasts = []

        genders.forEach { gender ->
            levels.forEach { level ->
                categories.forEach { category ->

                    rankedGymnasts << [gender: gender,
                                       level: level,
                                       category: category,
                                       gymnasts: rankGymnastsByScoreAndLevelAndCategoryAndGender(tournament, level, category, gender)]

                }
            }
        }

        rankedGymnasts
    }

}
