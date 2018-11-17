package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClubController {

    ClubService clubService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond clubService.list(params), model:[clubCount: clubService.count()]
    }

    def show(Long id) {
        respond clubService.get(id)
    }

    def create() {
        respond new Club(params)
    }

    def save(Club club) {
        if (club == null) {
            notFound()
            return
        }

        try {
            clubService.save(club)
        } catch (ValidationException e) {
            respond club.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'club.label', default: 'Club'), club.id])
                redirect club
            }
            '*' { respond club, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond clubService.get(id)
    }

    def update(Club club) {
        if (club == null) {
            notFound()
            return
        }

        try {
            clubService.save(club)
        } catch (ValidationException e) {
            respond club.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'club.label', default: 'Club'), club.id])
                redirect club
            }
            '*'{ respond club, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        clubService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'club.label', default: 'Club'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'club.label', default: 'Club'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
