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

    List<Map> rankAllAround(tournament) {

        def levels = levelService.list()
        def categories = categoryService.list()

        def result = []

        levels.forEach { level ->
            categories.forEach { category ->

                def rankedGymnasts = rankGymnastsByScoreAndLevelAndCategory(tournament, level, category)

                if(rankedGymnasts) {
                    result << [level: level,
                               category: category,
                               rank: rankedGymnasts]
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
                new WinCondition(tournament: tournament, club: scoresByClub.key, scores: limitedScores, totalScore: limitedScores.sum { it.score }, level: level)
            }

            result
        }
    }

    List<Map> rankClubs(tournament) {
        def result = []

        levelService.list().forEach { level ->
            def rankedClubsByLevel = rankClubsByLevel(tournament, level)

            if (rankedClubsByLevel) {
                result << [level: level, rank: rankedClubsByLevel]
            }
        }

        result
    }


    List<Map> rankExercises(tournament) {
        def result = []

        levelService.list().forEach { level ->
            categoryService.list().forEach { category ->
                exerciseService.list().forEach { exercise ->
                    def rankedGymnastsByExercise = rankGymnastsByExerciseAndLevelAndCategory(tournament, exercise, level, category)

                    if(rankedGymnastsByExercise) {
                        result << [level: level, category: category, exercise: exercise, rank: rankedGymnastsByExercise]
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
            def sortedScores = exerciseScores.sort { -it.score }
            def result = sortedScores.collect { sortedScore ->
                new WinCondition(gymnast:sortedScore.gymnast, tournament: tournament, exercise: exercise, scores: [sortedScore], totalScore: sortedScore.score, level: level, category: category)
            }

            result
        }
    }



}
