package fug.tournament.api

class Exercise {

    static constraints = {
        name size: 0..50
    }

    String name

    String toString() { this.name }
}
