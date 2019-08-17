package fug.tournament.api

class Gymnast {

    static constraints = {
        name size: 0..50, nullable: false
        nationalIdentityDocumentNumber nullable: false, unique: true
        birthDate nullable: false
        gender nullable: false
        club nullable: false
        medicalRecordDueDate nullable: true
        level nullable: true
        category nullable: true
    }

    static hasMany = [scores: Score]

    String name
    Long nationalIdentityDocumentNumber
    Gender gender
    Date birthDate
    Date medicalRecordDueDate
    Club club
    Level level
    Category category

    String toString() {
        "${this.name} (${this.nationalIdentityDocumentNumber}) [${this.club}]"
    }
}
