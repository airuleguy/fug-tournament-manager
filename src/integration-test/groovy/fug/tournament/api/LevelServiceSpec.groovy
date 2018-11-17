package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LevelServiceSpec extends Specification {

    LevelService levelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Level(...).save(flush: true, failOnError: true)
        //new Level(...).save(flush: true, failOnError: true)
        //Level level = new Level(...).save(flush: true, failOnError: true)
        //new Level(...).save(flush: true, failOnError: true)
        //new Level(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //level.id
    }

    void "test get"() {
        setupData()

        expect:
        levelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Level> levelList = levelService.list(max: 2, offset: 2)

        then:
        levelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        levelService.count() == 5
    }

    void "test delete"() {
        Long levelId = setupData()

        expect:
        levelService.count() == 5

        when:
        levelService.delete(levelId)
        sessionFactory.currentSession.flush()

        then:
        levelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Level level = new Level()
        levelService.save(level)

        then:
        level.id != null
    }
}
