package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GymnastServiceSpec extends Specification {

    GymnastService gymnastService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Gymnast(...).save(flush: true, failOnError: true)
        //new Gymnast(...).save(flush: true, failOnError: true)
        //Gymnast gymnast = new Gymnast(...).save(flush: true, failOnError: true)
        //new Gymnast(...).save(flush: true, failOnError: true)
        //new Gymnast(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //gymnast.id
    }

    void "test get"() {
        setupData()

        expect:
        gymnastService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Gymnast> gymnastList = gymnastService.list(max: 2, offset: 2)

        then:
        gymnastList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        gymnastService.count() == 5
    }

    void "test delete"() {
        Long gymnastId = setupData()

        expect:
        gymnastService.count() == 5

        when:
        gymnastService.delete(gymnastId)
        sessionFactory.currentSession.flush()

        then:
        gymnastService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Gymnast gymnast = new Gymnast()
        gymnastService.save(gymnast)

        then:
        gymnast.id != null
    }
}
