package fug.tournament.api

enum Gender {
    MALE ("Masculino"),
    FEMALE ("Femenino")

    def label

    Gender (label) {
        this.label = label
    }

    String toString() {
        this.label
    }
}