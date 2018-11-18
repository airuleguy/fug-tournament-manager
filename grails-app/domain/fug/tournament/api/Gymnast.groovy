package fug.tournament.api

class Gymnast {

    static constraints = {
        name size: 0..50, nullable: false
        birthDate nullable: false
        gender nullable: false
        medicalRecordDueDate nullable: true
        club nullable: false
        level nullable: true
        category nullable: true
    }

    String name
    Gender gender
    Date birthDate
    Date medicalRecordDueDate
    Club club
    Level level
    Category category

    String toString() {
        "${this.name} [${this.club}]"
    }
}
