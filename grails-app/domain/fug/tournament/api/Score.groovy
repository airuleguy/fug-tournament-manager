package fug.tournament.api

class Score {

    static constraints = {
        tournament display: false
    }

    static belongsTo = [tournament: Tournament]

    Gymnast gymnast
    Exercise exercise
    double score

    String toString() {
        "[${this.score}]: ${this.gymnast} - ${this.exercise}"
    }
}
