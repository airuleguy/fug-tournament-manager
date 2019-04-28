package fug.tournament.api

enum TournamentType {
    A_FEDERATED("Federados A", ["MALE": 99, "FEMALE":99]), // TODO Using an arbitrarily high number here is horrible. Fix later.
    B_FEDERATED("Federados B", ["MALE": 4, "FEMALE":3])

    def label
    def exercisesLimit // best scores

    TournamentType(label, exercisesLimit) {
        this.label = label
        this.exercisesLimit = exercisesLimit
    }

    String toString() {
        this.label
    }

    def getExercisesLimit(Gender gender) {
        this.exercisesLimit.get(gender.name())
    }
}