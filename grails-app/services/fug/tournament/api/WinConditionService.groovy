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


    def limitScoresByTournamentType(tournament, scores) {
        def scoresByGymnast = scores.value.groupBy { it.gymnast }
        scoresByGymnast.collect { gymnastScores ->
            gymnastScores.value.sort { -it.score }.take(tournament.type.getExercisesLimit(tournament.gender))
        }.flatten()
    }


    /**
     * Returns a list of maps with following form:
     *  [gymnast: Gymnast, scores: List<Score>, total_score:[]]
     * @param tournamentId
     * @param levelId
     * @param categoryId
     * @param gender
     * @return
     */
    List<Map> rankGymnastsByScoreAndLevelAndCategory(tournament, level, category) {

        def tournamentScores = Score.withCriteria {
            and {
                eq("tournament", tournament)
                gymnast {
                    eq("category", category )
                    eq("level", level)
                }
            }
        }

        if(tournamentScores.size > 0) {
            def gymnastScores = tournamentScores.groupBy { score -> score.gymnast }

            def result = gymnastScores.collect { scoresByGymnast ->
                def limitedScores = limitScoresByTournamentType(tournament, scoresByGymnast)
                [gymnast: scoresByGymnast.key, scores: limitedScores, total_score: limitedScores.sum { it.score }]
            }

            result
        }
    }

    List<Map> rankAllAround(tournamentId) {

        def tournament = tournamentService.get(tournamentId)

        def levels = Level.findAll()
        def categories = Category.findAll()

        def result = []

        levels.forEach { level ->
            categories.forEach { category ->

                def rankedGymnasts = rankGymnastsByScoreAndLevelAndCategory(tournament, level, category)

                if(rankedGymnasts) {
                    result << [gender: tournament.gender,
                                       level: level,
                                       category: category,
                                       gymnasts: rankedGymnasts]
                }
            }
        }

        result
    }


    List<Map> rankClubsByLevel(tournament, level) {

        def tournamentScores = Score.withCriteria {
            and {
                eq("tournament", tournament)
                gymnast {
                    eq("level", level)
                    groupProperty("level")
                }
            }
        }

        if(tournamentScores.size > 0) {
            def clubScores = tournamentScores.groupBy { score -> score.gymnast.club }

            def result = clubScores.collect { scoresByClub ->
                def limitedScores = limitScoresByTournamentType(tournament, scoresByClub)
                [club: scoresByClub.key, scores: limitedScores, total_score: limitedScores.sum { it.score }]
            }

            result
        }
    }

    List<Map> rankClubs(tournamentId) {
        def tournament = tournamentService.get(tournamentId)

        def result = []

        Level.findAll().forEach { level ->
            def rankedClubsByLevel = rankClubsByLevel(tournament, level)

            if (rankedClubsByLevel) {
                result << rankedClubsByLevel
            }
        }

        result
    }


    
}
