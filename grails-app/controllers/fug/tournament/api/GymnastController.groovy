package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GymnastController {

    GymnastService gymnastService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond gymnastService.list(params), model:[gymnastCount: gymnastService.count()]
    }

    def show(Long id) {
        respond gymnastService.get(id)
    }

    def create() {
        respond new Gymnast(params)
    }

    def save(Gymnast gymnast) {
        if (gymnast == null) {
            notFound()
            return
        }

        try {
            gymnastService.save(gymnast)
        } catch (ValidationException e) {
            respond gymnast.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gymnast.label', default: 'Gymnast'), gymnast.id])
                redirect gymnast
            }
            '*' { respond gymnast, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond gymnastService.get(id)
    }

    def update(Gymnast gymnast) {
        if (gymnast == null) {
            notFound()
            return
        }

        try {
            gymnastService.save(gymnast)
        } catch (ValidationException e) {
            respond gymnast.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'gymnast.label', default: 'Gymnast'), gymnast.id])
                redirect gymnast
            }
            '*'{ respond gymnast, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        gymnastService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'gymnast.label', default: 'Gymnast'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gymnast.label', default: 'Gymnast'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
