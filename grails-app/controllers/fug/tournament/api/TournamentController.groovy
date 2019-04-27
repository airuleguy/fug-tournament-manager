package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TournamentController {

    def winConditionService
    def tournamentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tournamentService.list(params), model:[tournamentCount: tournamentService.count()]
    }

    def show(Long id) {
        respond tournamentService.get(id)
    }

    def create() {
        respond new Tournament(params)
    }

    def save(Tournament tournament) {
        if (tournament == null) {
            notFound()
            return
        }

        try {
            tournamentService.save(tournament)
        } catch (ValidationException e) {
            respond tournament.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tournament.label', default: 'Tournament'), tournament.id])
                redirect tournament
            }
            '*' { respond tournament, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tournamentService.get(id)
    }

    def update(Tournament tournament) {
        if (tournament == null) {
            notFound()
            return
        }

        try {
            tournamentService.save(tournament)
        } catch (ValidationException e) {
            respond tournament.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tournament.label', default: 'Tournament'), tournament.id])
                redirect tournament
            }
            '*'{ respond tournament, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tournamentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tournament.label', default: 'Tournament'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tournament.label', default: 'Tournament'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
