package fug.tournament.api

class Club {

    static constraints = {
        name size: 0..50
    }

    String name
    static hasMany = [gymnasts: Gymnast]
}
