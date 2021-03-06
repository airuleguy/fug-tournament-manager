package fug.tournament.api.score

import fug.tournament.api.Score
import fug.tournament.api.tournament.TournamentService
import grails.gorm.services.Service

@Service(Score)
abstract class ScoreDataService implements IScoreDataService {

    TournamentService tournamentService

    List<Score> list(Map args) {
        def tournament = tournamentService.get(args.tournamentId as long)
        Score.findAllByTournament(tournament, [max: args.max, offset: args.offset ?: 0])
    }
}
