package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ScoreController {

    def scoreDataService
    def tournamentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def tournament = tournamentService.get(params.tournamentId)
        respond scoreDataService.list(params), model:[scoreCount: scoreDataService.count(), tournament: tournament]
    }

    def show(Long id) {
        respond scoreDataService.get(id)
    }

    def create() {
        respond new Score(params)
    }

    def save(Score score) {
        if (score == null) {
            notFound()
            return
        }

        try {
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
            '*' { respond score, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond scoreDataService.get(id)
    }

    def update(Score score) {
        if (score == null) {
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
            }
            '*'{ respond score, [status: OK] }
        }
    }

    def delete(Long id) {
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
