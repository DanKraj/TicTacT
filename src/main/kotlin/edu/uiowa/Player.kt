package edu.uiowa

import java.util.ArrayList

interface PlayerI{

    //val playerNumber: Int

    var numWins: Int
    fun getPlayer(): Int

}



class Player(playerNumber: Int): PlayerI {
    val playerNum = playerNumber

    override fun getPlayer(): Int{
        return this.playerNum
    }

    override var numWins: Int
        get() = numWins
        set(value) {this.numWins = value}


}