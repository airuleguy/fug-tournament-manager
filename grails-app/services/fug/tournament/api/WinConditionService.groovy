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


    def rankGymnastsByScore(tournamentId, levelId, categoryId, gender) {

        def tournament = tournamentService.get(tournamentId)
        def level = levelService.get(levelId)
        def category = categoryService.get(categoryId)

        def tournamentScores = Score.withCriteria {
            eq("tournament", tournament)
            gymnast {
                and {
                    eq("level", level)
                    eq("category", category)
                    eq("gender", Gender.valueOf(gender))
                }
            }
            order "gymnast", "desc"
            order "score", "desc"
        }

        tournamentScores
    }
}
