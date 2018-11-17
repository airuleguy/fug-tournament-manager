package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExerciseServiceSpec extends Specification {

    ExerciseService exerciseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Exercise(...).save(flush: true, failOnError: true)
        //new Exercise(...).save(flush: true, failOnError: true)
        //Exercise exercise = new Exercise(...).save(flush: true, failOnError: true)
        //new Exercise(...).save(flush: true, failOnError: true)
        //new Exercise(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //exercise.id
    }

    void "test get"() {
        setupData()

        expect:
        exerciseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Exercise> exerciseList = exerciseService.list(max: 2, offset: 2)

        then:
        exerciseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        exerciseService.count() == 5
    }

    void "test delete"() {
        Long exerciseId = setupData()

        expect:
        exerciseService.count() == 5

        when:
        exerciseService.delete(exerciseId)
        sessionFactory.currentSession.flush()

        then:
        exerciseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Exercise exercise = new Exercise()
        exerciseService.save(exercise)

        then:
        exercise.id != null
    }
}
