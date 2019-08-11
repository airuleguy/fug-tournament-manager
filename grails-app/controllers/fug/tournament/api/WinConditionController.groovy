package fug.tournament.api

class WinConditionController {

    def winConditionService
    def tournamentService

    def allAround(Long tournamentId) {

        def tournament = tournamentService.get(tournamentId)
        def rankedGymnasts = winConditionService.rankAllAround(tournament)

        render(view:"allAround", model:[tournament: tournament, ranking: rankedGymnasts, props: ["gymnast", "totalScore"]])
    }

    def clubs(Long tournamentId) {

        def tournament = tournamentService.get(tournamentId)
        def rankedClubs = winConditionService.rankClubs(tournament)

        render(view:"clubs", model:[tournament: tournament, ranking: rankedClubs, props: ["club", "totalScore"]])
    }

    def exercises(Long tournamentId) {

        def tournament = tournamentService.get(tournamentId)
        def rankedGymnasts = winConditionService.rankExercises(tournament)

        render(view:"exercises", model:[tournament: tournament, ranking: rankedGymnasts, props: ["gymnast", "totalScore"]])
    }
}
