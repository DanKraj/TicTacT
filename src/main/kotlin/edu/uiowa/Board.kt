package edu.uiowa

import java.util.ArrayList



interface boardOperations{
    //var board: ArrayList<ArrayList<Int>>
    fun makeMove(column: Int, row: Int, player: Int): Boolean
    fun checkWin(column: Int, row: Int, player: Int): Boolean
    fun getBoard(): ArrayList<ArrayList<Int>>
    fun clearBoard()
}

class Board(): boardOperations{
    private var board: ArrayList<ArrayList<Int>> = arrayListOf()

    init {
        board = arrayListOf<ArrayList<Int>>()
        for (i in 0..2){
            board.add(arrayListOf<Int>())
            for(j in 0..2){
                board[i].add(0)
            }
        }
    }

    override fun clearBoard() {
        for (i in 0..2){
            for(j in 0..2){
                board[i][j]=0
            }
        }
    }

    override fun getBoard(): ArrayList<ArrayList<Int>> {
        return this.board
    }


    override fun checkWin(column: Int, row: Int, player: Int):Boolean {


        var horizontal = true
        var vertical = true
        var LRdiagonal = true
        var RLdiagonal = true
        //Checks win horizontally/vertically

        var i = 0
        var j = 2
        while (i<=2){
            if (board[column][i] != player){
                vertical = false
            }
            if(board[i][row] != player){
                horizontal = false
                //println(board[])
            }
            if(board[i][i]!= player){
                LRdiagonal = false
            }
            if (board[j][i] != player){
                RLdiagonal = false
            }
            i++
            j--
        }
        return(RLdiagonal || LRdiagonal || horizontal || vertical)
        //Checks if move is in a diagonal position
        //0,0 - 1,1 - 2,2        2,0 - 1,1 - 0,2

    }

    override fun makeMove(column: Int, row: Int, player: Int): Boolean {

        //Checks if there is a valid move, if there isnt,

        //Is move inbounds on board
        if (row < 0 || column < 0 || row >2 || column > 2){
            println("Please enter a valid position")
            return false
        }
        //Is position already occupied
        else if(board[column][row] != 0){
            println("Position already occupied, please select an empty position")
            return false
        }
        else{
            board[column][row] = player
            return true
        }
    }


}
