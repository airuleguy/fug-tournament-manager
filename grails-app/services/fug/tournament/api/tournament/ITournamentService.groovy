package fug.tournament.api.tournament

import fug.tournament.api.Tournament

interface ITournamentService {

    Tournament get(Serializable id)

    List<Tournament> list(Map args)

    Long count()

    void delete(Serializable id)

    Tournament save(Tournament tournament)

}