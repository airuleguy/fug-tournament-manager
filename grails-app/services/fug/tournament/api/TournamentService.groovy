package fug.tournament.api

import grails.gorm.services.Service

@Service(Tournament)
interface TournamentService {

    Tournament get(Serializable id)

    List<Tournament> list(Map args)

    Long count()

    void delete(Serializable id)

    Tournament save(Tournament tournament)

}