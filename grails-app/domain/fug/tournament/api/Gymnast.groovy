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
        nationalIdentityDocumentNumber nullable: false
    }

    static hasMany = [scores: Score]

    String name
    Gender gender
    Date birthDate
    Date medicalRecordDueDate
    Club club
    Level level
    Category category
    Long nationalIdentityDocumentNumber

    String toString() {
        "${this.name} (${this.nationalIdentityDocumentNumber}) [${this.club}]"
    }
}
