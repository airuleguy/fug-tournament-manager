package fug.tournament.api

import grails.gorm.services.Service

@Service(Score)
interface ScoreService {

    Score get(Serializable id)

    List<Score> list(Map args)

    Long count()

    void delete(Serializable id)

    Score save(Score score)

}