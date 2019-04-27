package fug.tournament.api

import grails.converters.JSON

class WinConditionController {

    def winConditionService

    def rank(Long tournamentId) {

        def rankedGymnasts = winConditionService.rankGymnastsByScore(tournamentId)

        //render(view:"index", model:[winners: rankedGymnasts, count: rankedGymnasts.size(), levels: null])
        render rankedGymnasts as JSON
    }
}
