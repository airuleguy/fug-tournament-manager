package fug.tournament.api

class Score {

    static constraints = {
    }

    static belongsTo = [tournament: Tournament]

    Gymnast gymnast
    Exercise exercise
    double score
}
