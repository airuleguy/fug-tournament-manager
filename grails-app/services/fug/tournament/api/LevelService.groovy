package fug.tournament.api

import grails.gorm.services.Service

@Service(Level)
interface LevelService {

    Level get(Serializable id)

    List<Level> list(Map args)

    Long count()

    void delete(Serializable id)

    Level save(Level level)

}