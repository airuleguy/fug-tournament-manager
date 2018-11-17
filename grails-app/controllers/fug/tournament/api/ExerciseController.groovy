package fug.tournament.api

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExerciseController {

    ExerciseService exerciseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond exerciseService.list(params), model:[exerciseCount: exerciseService.count()]
    }

    def show(Long id) {
        respond exerciseService.get(id)
    }

    def create() {
        respond new Exercise(params)
    }

    def save(Exercise exercise) {
        if (exercise == null) {
            notFound()
            return
        }

        try {
            exerciseService.save(exercise)
        } catch (ValidationException e) {
            respond exercise.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'exercise.label', default: 'Exercise'), exercise.id])
                redirect exercise
            }
            '*' { respond exercise, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond exerciseService.get(id)
    }

    def update(Exercise exercise) {
        if (exercise == null) {
            notFound()
            return
        }

        try {
            exerciseService.save(exercise)
        } catch (ValidationException e) {
            respond exercise.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'exercise.label', default: 'Exercise'), exercise.id])
                redirect exercise
            }
            '*'{ respond exercise, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        exerciseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'exercise.label', default: 'Exercise'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'exercise.label', default: 'Exercise'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
