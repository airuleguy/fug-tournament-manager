package fug.tournament.api

enum TournamentType {
    A_FEDERATED("Federados A", 99), // TODO Using an arbitrarily high number here is horrible. Fix later.
    B_FEDERATED("Federados B", 3)

    def label
    def exerciseLimit // best scores

    TournamentType(label, exerciseLimit) {
        this.label = label
        this.exerciseLimit = exerciseLimit
    }

    String toString() {
        this.label
    }
}