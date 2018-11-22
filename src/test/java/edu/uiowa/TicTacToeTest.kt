package edu.uiowa

import org.junit.Test
import org.junit.Assert.*
import kotlin.math.absoluteValue


class TicTacToeTest {
    /*
    @Test
    fun test1() {
        // create a very simple Stack
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.push("Hello"), kotlin.Unit)
        assertEquals(T.peek(), "Hello")
        assertEquals(T.size, 1)
        assertEquals(T.isEmpty, false)
        assertEquals(T.hasElem("Hello"), true)
        assertEquals(T.hasElem("hello"), false)
        assertEquals(T.pop(), "Hello")
        assertEquals(T.size, 0)
        assertEquals(T.isEmpty, true)
        assertEquals(T.hasElem("Hello"), false)
        }

    @Test(expected = StackError::class)
    fun test2() {
        // create empty stack and try to peek - should trigger StackError
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.peek(),"")
        }

    @Test(expected = StackError::class)
    fun test3() {
        // create empty stack and try to pop - should trigger StackError
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.pop(),"")
        }

    @Test

    fun test4() {
        // create and make stack with three items
        val T: Stack<String> = EasyStack<String>()
        T.push("Hello")
        T.push("to")
        T.push("everybody")
        var collect = ""  // use this later to collect pop()
        assertEquals(T.size,3)
        assertTrue(T.hasElem("to"))
        assertEquals(T.peek(),"everybody")
        collect = collect + T.pop()
        collect = collect + T.pop()
        collect = collect + T.pop()
        assertEquals(T.size,0)
        assertEquals(collect,"everybodytoHello")
        }

    @Test
    fun test10() {
        val E = EasyTokenizer()
        E.addSymbol("[")
        E.addSymbol("]")
        //assertEquals(listOf<String>(),E.tokenize("")) // eddge case
        assertEquals(listOf("ab","[","cd"),E.tokenize("ab[cd"))
        assertEquals(listOf("[","hello","]"),E.tokenize("[hello]"))
        assertEquals(listOf("[","[","hello","]"),E.tokenize("[[hello]"))
        assertEquals(listOf("[","[","hello","]"),E.tokenize(" [[ hello ]"))
    }

    @Test
    fun test11() {
        val E = EasyTokenizer()
        E.addSymbol(";")
        E.addSymbol("-")
        //E.addSymbol("---")
        val D = E.tokenize("abc;def-----xyz---lmn-o;-")
        val K = E.tokenize("abc ; def --- -- xyz--- lmn - o;-")
        assertEquals(D,K)
        }

    @Test
    fun test12() {
        val E = EasyTokenizer()
        E.addSymbol("*")
        E.addSymbol("**")
        E.addSymbol("+")
        E.addSymbol("++")
        val D = E.tokenize("f a5++big+n * d**35")
        assertEquals(listOf("f","a5","++","big","+","n","*","d","**","35"),D)
        }
        */

    @Test
    fun playerTest1(){
        val player = Player(1)
        assertEquals(1, player.getPlayer())
    }

    @Test
    fun boardTest1(){
        val board = Board()
        assertEquals(3, board.getBoard().size)
        assertEquals(3, board.getBoard()[0].size)
        assertEquals(3, board.getBoard()[1].size)
        assertEquals(3, board.getBoard()[2].size)
    }

    @Test
    fun boardTest2(){
        val board = Board()
        board.makeMove(0, 0, 1)
        assertEquals(1, board.getBoard()[0][0])
        board.makeMove(1, 0, 2)
        assertEquals(2, board.getBoard()[1][0])
    }

    @Test
    fun boardTest3(){
        val board = Board()
        assertFalse(board.makeMove(-1, 0, 1))
        assertFalse(board.makeMove(2, 3, 2))
    }

    @Test
    fun boardTest4(){
        val board = Board()
        board.makeMove(0, 0, 1)
        assertFalse(board.makeMove(0, 0, 1))
        assertFalse(board.makeMove(0, 0, 2))
    }

    @Test
    //Checks vertical win condition
    fun boardTest5(){
        val board = Board()
        board.makeMove(0, 0, 1)
        board.makeMove(0, 1, 1)
        board.makeMove(0, 2, 1)
        assertTrue(board.checkWin(0, 2, 1))
    }

    @Test
    fun boardTest6(){
        val board = Board()
        board.makeMove(0, 0, 1)
        board.makeMove(1, 0, 1)
        board.makeMove(2, 0, 1)
        println(board.getBoard())
        assertTrue(board.checkWin(2, 0, 1))
        assertFalse(board.checkWin(2, 0, 2))
    }

    //Checks for win from left-right diagonal
    @Test
    fun boardTest7(){
        val board = Board()
        board.makeMove(0, 0, 1)
        board.makeMove(1, 1, 1)
        board.makeMove(2, 2, 1)
        assertTrue(board.checkWin(2, 2, 1))
        assertFalse(board.checkWin(2, 2, 2))
    }

    @Test
    fun boardTest8(){
        val board = Board()
        board.makeMove(2, 0, 1)
        board.makeMove(1, 1, 1)
        board.makeMove(0, 2, 1)
        assertTrue(board.checkWin(0, 2, 1))
        assertFalse(board.checkWin(0, 2, 2))
    }

    @Test
    fun boardTest9(){
        val board = Board()
        board.makeMove(2, 0, 1)
        board.makeMove(1, 1, 1)
        board.makeMove(0, 2, 1)
        board.clearBoard()
        assertEquals(0, board.getBoard()[2][0])
        assertEquals(0, board.getBoard()[1][1])
        assertEquals(0, board.getBoard()[0][2])
    }

    @Test
    //Checks to make sure current player is swapped when necesarry
    fun gameTest1(){
        val game = Game()
        game.makeMove(0, 0)
        assertEquals(2, game.currentPlayer)
        game.makeMove(0, 0)
        assertEquals(2, game.currentPlayer)
        game.makeMove(0, 1)
        assertEquals(1, game.currentPlayer)
    }

    @Test
    //Tests basic win condition, all other covered by board testing
    fun gameTest2(){
        val game = Game()
        game.makeMove(0, 0)
        game.makeMove(1, 0)
        game.makeMove(1, 1)
        game.makeMove(1, 2)
        game.makeMove(2, 2)
        assertTrue(game.gameOver)
    }

    @Test
    //Checks for draw condition
    fun gameTest3(){
        val game = Game()
        game.makeMove(0, 0)
        game.makeMove(1, 0)
        game.makeMove(2, 0)
        game.makeMove(2, 2)
        game.makeMove(1, 2)
        game.makeMove(0, 2)
        game.makeMove(0, 1)
        game.makeMove(1, 1)
        game.makeMove(2, 1)
        assertTrue(game.gameOver)
    }

    @Test
    fun gameTest4(){
        val game = Game()
        game.makeMove(0, 0)
        game.makeMove(1, 0)
        game.makeMove(1, 1)
        game.makeMove(1, 2)
        game.makeMove(2, 2)
        assertTrue(game.gameOver)
        game.resetGame()
        assertEquals(9, game.markCount)
        assertEquals(1, game.currentPlayer)
        assertFalse(game.gameOver)
    }

    }



