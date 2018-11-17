package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ScoreServiceSpec extends Specification {

    ScoreService scoreService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Score(...).save(flush: true, failOnError: true)
        //new Score(...).save(flush: true, failOnError: true)
        //Score score = new Score(...).save(flush: true, failOnError: true)
        //new Score(...).save(flush: true, failOnError: true)
        //new Score(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //score.id
    }

    void "test get"() {
        setupData()

        expect:
        scoreService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Score> scoreList = scoreService.list(max: 2, offset: 2)

        then:
        scoreList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        scoreService.count() == 5
    }

    void "test delete"() {
        Long scoreId = setupData()

        expect:
        scoreService.count() == 5

        when:
        scoreService.delete(scoreId)
        sessionFactory.currentSession.flush()

        then:
        scoreService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Score score = new Score()
        scoreService.save(score)

        then:
        score.id != null
    }
}
