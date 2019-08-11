package fug.tournament.manager

import fug.tournament.api.Category
import fug.tournament.api.Club
import fug.tournament.api.Exercise
import fug.tournament.api.Gender
import fug.tournament.api.Gymnast
import fug.tournament.api.Level
import fug.tournament.api.Score
import fug.tournament.api.Tournament
import fug.tournament.api.TournamentType

class BootStrap {

    def init = { servletContext ->
        environments {
            test {
                loadMockData()
            }

            development {

            }

            production {

            }
        }
    }
    def destroy = {
    }


    def loadMockData() {
        loadMockCategories()
        loadMockClubs()
        loadMockExercises()
        loadMockLevels()
        loadMockGymnasts()
        loadMockTournaments()
        loadMockScores()
    }

    def loadMockCategories() {
        new Category(name: "MINI").save(flush:true)
        new Category(name: "PREINF").save(flush:true)
        new Category(name: "INF").save(flush:true)
        new Category(name: "JUV").save(flush:true)
        new Category(name: "MAY").save(flush:true)
        new Category(name: "PROM").save(flush:true)
    }

    def loadMockClubs() {
        new Club(name:  "Bella Italia", gymnasts: []).save(flush: true)
        new Club(name:  "Campus", gymnasts: []).save(flush: true)
        new Club(name:  "CBVB", gymnasts: []).save(flush: true)
        new Club(name:  "Durazno", gymnasts: []).save(flush: true)
        new Club(name:  "Fray Bentos", gymnasts: []).save(flush: true)
        new Club(name:  "Gimnasio Guadalupe", gymnasts: []).save(flush: true)
        new Club(name:  "Hebraica", gymnasts: []).save(flush: true)
        new Club(name:  "IFG", gymnasts: []).save(flush: true)
        new Club(name:  "Malvín", gymnasts: []).save(flush: true)
        new Club(name:  "Scuola", gymnasts: []).save(flush: true)
    }

    def loadMockExercises() {
        //Unisex
        new Exercise(name: "Suelo").save(flush:true)
        new Exercise(name: "Salto").save(flush:true)

        // Ladies
        new Exercise(name: "Viga").save(flush:true)
        new Exercise(name: "Asimétricas").save(flush:true)

        // Gentlemen
        new Exercise(name: "Arzones").save(flush:true)
        new Exercise(name: "Anillas").save(flush:true)
        new Exercise(name: "Barra").save(flush:true)
        new Exercise(name: "Paralelas").save(flush:true)
    }

    def loadMockLevels() {
        new Level(name: "1").save(flush:true)
        new Level(name: "2").save(flush:true)
        new Level(name: "3").save(flush:true)
        new Level(name: "4").save(flush:true)
        new Level(name: "5").save(flush:true)
    }

    def loadMockGymnasts() {
        new Gymnast([
                name:   "UMA FERRADANS",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(1),
                level: Level.get(1),
                category: Category.get(1),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "MILAGROS IRIGOITE",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(1),
                level: Level.get(1),
                category: Category.get(2),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "MARIA NOEL SIERRA",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(1),
                level: Level.get(1),
                category: Category.get(3),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "ROMINA SOSA",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(1),
                level: Level.get(2),
                category: Category.get(4),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "JOSEFINA CUADRA",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(2),
                level: Level.get(1),
                category: Category.get(6),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "LUCIA GIMENEZ",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(2),
                level: Level.get(1),
                category: Category.get(2),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "CATALINA PORTILLO",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(2),
                level: Level.get(2),
                category: Category.get(1),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "Delfina Raij",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(3),
                level: Level.get(3),
                category: Category.get(3),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "FAUSTINA TROISI",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(2),
                level: Level.get(1),
                category: Category.get(6),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "MICAELA AYALA",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(8),
                level: Level.get(5),
                category: Category.get(5),
                gender: Gender.FEMALE
        ]).save(flush:true)

        new Gymnast([
                name:   "Samira Zarzar",
                birthDate: (new Date()) - 100,
                medicalRecordDueDate: (new Date()) + 50,
                club: Club.get(10),
                level: Level.get(3),
                category: Category.get(2),
                gender: Gender.FEMALE
        ]).save(flush:true)
    }

    def loadMockTournaments() {
        new Tournament(name: "Copa Olímpia", startDate: new Date(), endDate: new Date() + 1, type: TournamentType.A_FEDERATED, gender: Gender.FEMALE).save(flush:true)
        new Tournament(name: "Juegos Panamericanos de Cachito El Verdulero", startDate: new Date() + 100, endDate: new Date() + 110, type: TournamentType.B_FEDERATED, gender: Gender.FEMALE).save(flush:true)
    }

    def loadMockScores() {
        // UMA - Copa Olímpia
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(1),
                exercise: Exercise.get(1),
                score: 9.185
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(1),
                exercise: Exercise.get(2),
                score: 5.202
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(1),
                exercise: Exercise.get(3),
                score: 10
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(1),
                exercise: Exercise.get(4),
                score: 1.111
        ).save(flush:true)

        // MILAGROS - Copa Olímpia
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(1),
                score: 9
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(2),
                score: 8
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(3),
                score: 7
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(4),
                score: 6.111
        ).save(flush:true)

        // MARIA NOEL - Copa Olímpia
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(3),
                exercise: Exercise.get(1),
                score: 3.141
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(3),
                exercise: Exercise.get(2),
                score: 3.232
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(3),
                exercise: Exercise.get(3),
                score: 3.434
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(3),
                exercise: Exercise.get(4),
                score: 3.111
        ).save(flush:true)

        // LUCIA - Copa Olímpia
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(6),
                exercise: Exercise.get(1),
                score: 1
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(6),
                exercise: Exercise.get(2),
                score: 2
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(6),
                exercise: Exercise.get(3),
                score: 3
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(1),
                gymnast: Gymnast.get(6),
                exercise: Exercise.get(4),
                score: 4
        ).save(flush:true)


        // MILAGROS - Panamericano
        new Score(
                tournament: Tournament.get(2),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(1),
                score: 1
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(2),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(2),
                score: 1
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(2),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(3),
                score: 1
        ).save(flush:true)
        new Score(
                tournament: Tournament.get(2),
                gymnast: Gymnast.get(2),
                exercise: Exercise.get(4),
                score: 1
        ).save(flush:true)

    }
}
