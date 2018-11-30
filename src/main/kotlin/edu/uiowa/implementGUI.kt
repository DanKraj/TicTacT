package edu.uiowa

import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.TextField
import javafx.stage.Stage
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.ToggleGroup
import javafx.geometry.Pos
import javafx.scene.layout.GridPane



val game = Game()
val board = game.board
// some global variables simplify programming later
var current_stage: Stage? = null  // to remember which stage we are on
var textinput1: TextField? = null // to remember the textinput area # 1
var button1: Button? = null       // to remember the button # 1
val groupset1: Array<RadioButton?> = arrayOfNulls(3) // for radio buttons

class MyForm: Application() {
    override fun start(primaryStage: Stage) {
        current_stage = primaryStage

        val pane = GridPane()
        pane.alignment = Pos.CENTER
        for (i in 0..board.getSize() - 1) {
            for (j in 0..board.getSize() - 1) {
                val text = Button(" ")
                text.onAction = buttonController
                pane.add(text, i, j)

            }
        }
        val scene = Scene(pane, 150.0, 150.0)
        primaryStage.title = "Tic Tac Toe"
        primaryStage.scene = scene
        primaryStage.show()
        /*
        primaryStage.title = "Tic-Tac-Toe"
        val board = Board()
        for (item in board.getBoard()){

        }
        val  = Label()

        // our form will begin with a "vertical box"
        val vbox = VBox()
        vbox.setPrefSize(300.0,400.0) // size of the box
        // there is a confusing variety of "panes" for layout see
        // https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        vbox.style = "-fx-background-color: D9E8F7;"

        // within the vertical box, we add a "horizontal box"
        // which will have a label and a text input area
        val hbox1 = HBox()
        hbox1.setPadding(Insets(15.0, 12.0, 15.0, 12.0));
        hbox1.setSpacing(10.0);   // to make it look nicer
        vbox.children.add(hbox1)  // place new hbox inside the vbox

        // create an immutable label with some text in it
        val mylabel = Label("Type here")
        hbox1.children.add(mylabel)

        // then create text input area next to the label
        val t = TextField()
        t.onAction = textController    // what to call when Enter pressed
        hbox1.children.add(t)
        textinput1 = t // save reference to t in a global variable

        // now, moving vertically, we add another hbox, this for buttons
        val hbox2 = HBox()
        hbox2.setPadding(Insets(15.0, 12.0, 15.0, 12.0));
        hbox2.setSpacing(10.0);   // to make it look nicer
        vbox.children.add(hbox2)  // place new hbox inside the vbox

        // within hbox2, we put a Button
        val b = Button("Click Here") // text in button
        b.onAction = buttonController     // handler for button click
        hbox2.children.add(b)             // add button to vbox
        button1 = b                       // save reference to b in global var

        // put another label, this for selecting a radio button
        val question = Label("Choose your favorite color")
        vbox.children.add(question)

        // below the label, we add a "toggle group"
        val tgroup1 = ToggleGroup()
        // then add some radio buttons
        val r1 = RadioButton("Red")
        r1.toggleGroup = tgroup1
        r1.onAction = radioController
        vbox.children.add(r1)
        groupset1[0] = r1  // remember this radiobutton globally
        val r2 = RadioButton("Blue")
        r2.toggleGroup = tgroup1
        r2.onAction = radioController
        vbox.children.add(r2)
        groupset1[1] = r2
        val r3 = RadioButton("Green")
        r3.toggleGroup = tgroup1
        r3.onAction = radioController
        vbox.children.add(r3)
        groupset1[2] = r3

        // now run this first stage of the app
        // the run() method is sort of like "with" and "apply",
        // it needs a lambda with multiple lines, all of which
        // are technically working on primaryStage
        primaryStage.run {
            scene = Scene(vbox,300.0,400.0)
            show()
        }
    }
    */
    }


// define object with handle method for button1
object buttonController: EventHandler<ActionEvent> {
    override fun handle(event: ActionEvent) {
        val b = event.source as Button
        if (game.currentPlayer == 1){
            b.text = "X"
            game.currentPlayer = 2
            b.setDisable(true)
        }
        else{
            b.text = "O"
            game.currentPlayer = 1
            b.setDisable(true)
            //println(b.)
        }
        println("debugging button (is button1? ${b==button1})")
        println("value of textfield is ${textinput1?.text}")
    }
}
    /*

// define object with handle method for textfield1
object textController: EventHandler<ActionEvent> {
    override fun handle(event: ActionEvent) {
        val t = event.source as TextField
        assert (t==textinput1)  // demo of the assert statement
        println("input is: ${t.text}")
    }
}

object radioController: EventHandler<ActionEvent> {
    override fun handle(event: ActionEvent) {
        val r = event.source as RadioButton
        when (r) {
            groupset1[0] -> println("Red")
            groupset1[1] -> println("Blue")
            groupset1[2] -> println("Green")
            else -> { }
        }
    }
}
*/
}

    fun main(args: Array<String>) {
        launch(MyForm::class.java)
    }
