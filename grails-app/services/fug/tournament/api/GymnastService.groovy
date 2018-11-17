package fug.tournament.api

import grails.gorm.services.Service

@Service(Gymnast)
interface GymnastService {

    Gymnast get(Serializable id)

    List<Gymnast> list(Map args)

    Long count()

    void delete(Serializable id)

    Gymnast save(Gymnast gymnast)

}