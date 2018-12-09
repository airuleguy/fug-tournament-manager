package fug.tournament.api.score

import fug.tournament.api.Score

interface IScoreDataService {

    Score get(Serializable id)

    List<Score> list(Map args)

    Long count()

    void delete(Serializable id)

    Score save(Score score)

}