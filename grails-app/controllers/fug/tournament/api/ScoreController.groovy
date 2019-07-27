package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ScoreController {

    def scoreDataService
    def tournamentService

    static scaffold = Score
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long tournamentId, Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def tournament = tournamentService.get(tournamentId)
        respond scoreDataService.list(params), model:[scoreCount: scoreDataService.count(), tournament: tournament]
    }

    def show(Long tournamentId, Long id) {
        def tournament = tournamentService.get(tournamentId)
        respond scoreDataService.get(id), model:[tournament: tournament]
    }

    def create(Long tournamentId) {
        def tournament = tournamentService.get(tournamentId)
        respond new Score(params), model: [tournament: tournament]
    }

    def save(Long tournamentId, Score score) {

	    def tournament = tournamentService.get(tournamentId)
        if (score == null || tournament == null) {
            notFound()
            return
        }

        try {
	        score.tournament = tournament
            scoreDataService.save(score)
        } catch (ValidationException e) {
            respond score.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'score.label', default: 'Score'), score.id])
                redirect score
            }
            '*' { respond score, model:[status: CREATED, tournament: score.tournament] }
        }
    }

    def edit(Long tournamentId, Long id) {
        def tournament = tournamentService.get(tournamentId)
        respond scoreDataService.get(id), model: [tournament: tournament]
    }

    def update(Score score) {
        if (score == null || tournament == null) {
            notFound()
            return
        }

        try {
            scoreDataService.save(score)
        } catch (ValidationException e) {
            respond score.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'score.label', default: 'Score'), score.id])
                redirect score
            } // TODO not working! It won't use the correct URL defined in
            '*'{ redirect action: "show", params:[status: OK, tournament: score.tournament, score: score] }
        }
    }

    def delete(Long tournamentId, Long id) {
        if (id == null) {
            notFound()
            return
        }

        scoreDataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'score.label', default: 'Score'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'score.label', default: 'Score'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
