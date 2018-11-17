package fug.tournament.api

import grails.gorm.services.Service

@Service(Club)
interface ClubService {

    Club get(Serializable id)

    List<Club> list(Map args)

    Long count()

    void delete(Serializable id)

    Club save(Club club)

}