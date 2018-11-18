package fug.tournament.api

class Category {

    static constraints = {
        name size: 0..50
    }

    String name

    String toString() {
        this.name
    }
}
