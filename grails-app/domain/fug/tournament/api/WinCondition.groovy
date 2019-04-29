package fug.tournament.api

import javax.persistence.Transient

class WinCondition {
    @Transient
    Tournament tournament
    @Transient
    Level level
    @Transient
    Category category
    @Transient
    Exercise exercise
    @Transient
    Gymnast gymnast
    @Transient
    List<Score> scores
    @Transient
    Double totalScore
    @Transient
    Club club
}
