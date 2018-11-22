package edu.uiowa

interface gameOperations{
    /*
    var board: Board
    var player1: Player
    var player2 : Player
    var currentPlayer: Int
    var gameOver: Boolean
    */
    fun makeMove(column: Int, row: Int)
    fun nextPlayer()
    fun getBoard(): ArrayList<ArrayList<Int>>
    fun resetGame()

}




class Game():gameOperations{
    var board = Board()
    var player1 = Player(1)
    var player2 = Player(2)
    var markCount = 9
    var currentPlayer = 1
    var gameOver = false

    override fun resetGame() {
        this.board.clearBoard()
        currentPlayer = 1
        gameOver = false
        markCount = 9
    }

    override fun getBoard(): ArrayList<ArrayList<Int>> {
        return this.board.getBoard()
    }

    override fun makeMove(column: Int, row: Int) {
        //Checks if its a valid move, makes the move
        if (board.makeMove(column, row, currentPlayer)){
            markCount--
            //Checks if move resulted in a win for the player
            if (board.checkWin(column, row, currentPlayer)){
                println("Congradulations player $currentPlayer! You win!")
                gameOver = true
            }
            //Checks if there are any possible moves
            else if(markCount == 0){
                println("No more possible moves. It's a draw!")
                gameOver = true
            }
            else{
                nextPlayer()
            }


        }
    }

    override fun nextPlayer() {
        if (currentPlayer == 1){
            currentPlayer = 2
        }
        else{
            currentPlayer = 1
        }
    }

}