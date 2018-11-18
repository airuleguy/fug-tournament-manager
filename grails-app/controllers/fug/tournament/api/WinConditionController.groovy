package fug.tournament.api

class WinConditionController {

    def winConditionService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def rankedGymnasts = winConditionService.rankGymnastsByScore(1L, 1L, 2L, "FEMALE")
        render(view:"index", model:[winners: rankedGymnasts, count: rankedGymnasts.size()])
    }
}
