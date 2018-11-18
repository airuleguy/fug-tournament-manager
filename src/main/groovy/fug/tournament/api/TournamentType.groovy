package fug.tournament.api

enum TournamentType {
    A_FEDERATED("Federados A", Integer.MAX_VALUE), // TODO Using MAX_VALUE here is horrible. Fix later.
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