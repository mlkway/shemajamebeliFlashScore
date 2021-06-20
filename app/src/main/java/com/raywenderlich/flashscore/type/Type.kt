package com.raywenderlich.flashscore.type

enum class Type(var type: Int) {

    GOAL(1),
    YELLOW_CARD(2),
    RED_CARD(3),
    SUBSTITUTION(4)



}

enum class GoalType(var goalType: Int){
    GOAL(1),
    OWN_GOAL(2)

}

enum class MatchTeamType(var team: Int){
    TEAM1(1),
    TEAM2(2)
}