package fug.tournament.api

import grails.gorm.transactions.Transactional

@Transactional
class WinConditionService {

    def tournamentService

    def levelService
    def categoryService
    def exerciseService


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
                new WinCondition(tournament: tournament, gymnast: scoresByGymnast.key, scores: limitedScores, totalScore: limitedScores.sum { it.score }, level: level, category: category)
            }

            result
        }
    }

    List<Map> rankAllAround(tournamentId) {

        def tournament = tournamentService.get(tournamentId)

        def levels = levelService.list()
        def categories = categoryService.list()

        def result = []

        levels.forEach { level ->
            categories.forEach { category ->

                def rankedGymnasts = rankGymnastsByScoreAndLevelAndCategory(tournament, level, category)

                if(rankedGymnasts) {
                    result << [level: level,
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

        levelService.list().forEach { level ->
            def rankedClubsByLevel = rankClubsByLevel(tournament, level)

            if (rankedClubsByLevel) {
                result << rankedClubsByLevel
            }
        }

        result
    }


    List<Map> rankExercises(tournamentId) {
        def tournament = tournamentService.get(tournamentId)

        def result = []

        levelService.list().forEach { level ->
            categoryService.list().forEach { category ->
                exerciseService.list().forEach { exercise ->
                    def rankedGymnastsByExercise = rankGymnastsByExerciseAndLevelAndCategory(tournament, exercise, level, category)

                    if(rankedGymnastsByExercise) {
                        result << rankedGymnastsByExercise
                    }
                }
            }
        }

        result
    }


    def rankGymnastsByExerciseAndLevelAndCategory(tournament, exercise, level, category) {
        def exerciseScores = Score.withCriteria {
            and {
                eq("tournament", tournament)
                eq("exercise", exercise)
                gymnast {
                    eq("level", level)
                    eq("category", category)
                }
            }
        }

        if(exerciseScores.size > 0) {

            [level: level, category: category, execise: exercise, scores:exerciseScores.sort { -it.score }]
        }
    }



}
