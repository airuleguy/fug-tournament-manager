package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClubServiceSpec extends Specification {

    ClubService clubService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Club(...).save(flush: true, failOnError: true)
        //new Club(...).save(flush: true, failOnError: true)
        //Club club = new Club(...).save(flush: true, failOnError: true)
        //new Club(...).save(flush: true, failOnError: true)
        //new Club(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //club.id
    }

    void "test get"() {
        setupData()

        expect:
        clubService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Club> clubList = clubService.list(max: 2, offset: 2)

        then:
        clubList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        clubService.count() == 5
    }

    void "test delete"() {
        Long clubId = setupData()

        expect:
        clubService.count() == 5

        when:
        clubService.delete(clubId)
        sessionFactory.currentSession.flush()

        then:
        clubService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Club club = new Club()
        clubService.save(club)

        then:
        club.id != null
    }
}
