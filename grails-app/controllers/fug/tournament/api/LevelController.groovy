package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LevelController {

    LevelService levelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond levelService.list(params), model:[levelCount: levelService.count()]
    }

    def show(Long id) {
        respond levelService.get(id)
    }

    def create() {
        respond new Level(params)
    }

    def save(Level level) {
        if (level == null) {
            notFound()
            return
        }

        try {
            levelService.save(level)
        } catch (ValidationException e) {
            respond level.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'level.label', default: 'Level'), level.id])
                redirect level
            }
            '*' { respond level, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond levelService.get(id)
    }

    def update(Level level) {
        if (level == null) {
            notFound()
            return
        }

        try {
            levelService.save(level)
        } catch (ValidationException e) {
            respond level.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'level.label', default: 'Level'), level.id])
                redirect level
            }
            '*'{ respond level, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        levelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'level.label', default: 'Level'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'level.label', default: 'Level'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
