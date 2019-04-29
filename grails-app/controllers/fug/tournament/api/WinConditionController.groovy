package fug.tournament.api

import grails.converters.JSON

class WinConditionController {

    def winConditionService

    def allAround(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankAllAround(tournamentId)

        render(view:"index", model:[ranking: rankedGymnasts, props: ["gymnast", "totalScore"]])
    }

    def clubs(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankClubs(tournamentId)

        render(view:"index", model:[ranking: rankedGymnasts, props: ["gymnast", "totalScore"]])
    }

    def exercises(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankExercises(tournamentId)

        render(view:"index", model:[ranking: rankedGymnasts, props: ["gymnast", "totalScore"]])
    }
}
