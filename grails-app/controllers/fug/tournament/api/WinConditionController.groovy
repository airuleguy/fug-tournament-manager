package fug.tournament.api

import grails.converters.JSON

class WinConditionController {

    def winConditionService

    def allAround(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankAllAround(tournamentId)

        //render(view:"index", model:[winners: rankedGymnasts, count: rankedGymnasts.size(), levels: null])
        render rankedGymnasts as JSON
    }

    def clubs(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankClubs(tournamentId)

        //render(view:"index", model:[winners: rankedGymnasts, count: rankedGymnasts.size(), levels: null])
        render rankedGymnasts as JSON
    }
}
