package fug.tournament.api

class Tournament {

    static constraints = {
        name size: 0..100
        startDate nullable: false
        endDate nullable: false
        type nullable: false
        gender nullable: false
    }

    static hasMany = [scores: Score]

    String name
    Date startDate
    Date endDate
    TournamentType type
    Gender gender
}