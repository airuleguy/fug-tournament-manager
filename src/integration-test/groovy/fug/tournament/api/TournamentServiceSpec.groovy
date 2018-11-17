package fug.tournament.api

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TournamentServiceSpec extends Specification {

    TournamentService tournamentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tournament(...).save(flush: true, failOnError: true)
        //new Tournament(...).save(flush: true, failOnError: true)
        //Tournament tournament = new Tournament(...).save(flush: true, failOnError: true)
        //new Tournament(...).save(flush: true, failOnError: true)
        //new Tournament(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tournament.id
    }

    void "test get"() {
        setupData()

        expect:
        tournamentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tournament> tournamentList = tournamentService.list(max: 2, offset: 2)

        then:
        tournamentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tournamentService.count() == 5
    }

    void "test delete"() {
        Long tournamentId = setupData()

        expect:
        tournamentService.count() == 5

        when:
        tournamentService.delete(tournamentId)
        sessionFactory.currentSession.flush()

        then:
        tournamentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tournament tournament = new Tournament()
        tournamentService.save(tournament)

        then:
        tournament.id != null
    }
}
