package com.funofuntime.funofuntimes

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.funofuntime.funofuntimes.R.layout.activity_tic_tac_toe
import com.google.android.material.snackbar.Snackbar

class TicTacToe : AppCompatActivity() {
    var counter = 1
    var player1Symbol = "🍎"
    var player2Symbol = "🍐"
    var ticTacToeArray = arrayListOf("TTT", "", "", "", "", "", "", "", "","")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_tic_tac_toe)

        findViewById<Button>(R.id.homeButton).setOnClickListener{
            finish()
        }

        findViewById<Button>(R.id.startGameButton).setOnClickListener{
            if(checkplayers()) {
                findViewById<TableLayout>(R.id.ticTacToeTableLayout).visibility = View.VISIBLE
                findViewById<Button>(R.id.startGameButton).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.ticTacToeHeadertextView).text = "Now " + findViewById<TextView>(R.id.player1Name).text.toString() + "'s Turn"
                findViewById<TextView>(R.id.player1Name).isEnabled = false
                findViewById<TextView>(R.id.player2Name).isEnabled = false
                findViewById<TextView>(R.id.player1Symbol).isEnabled = false
                findViewById<TextView>(R.id.player2Symbol).isEnabled = false
            }
        }

        findViewById<Button>(R.id.playAgainButton).setOnClickListener{
            setTheBoard()
            findViewById<Button>(R.id.startGameButton).visibility = View.VISIBLE
            findViewById<Button>(R.id.playAgainButton).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.ticTacToeHeadertextView).text = "Tic Tac Toe"
            findViewById<TextView>(R.id.player1Name).isEnabled = true
            findViewById<TextView>(R.id.player2Name).isEnabled = true
            findViewById<TextView>(R.id.player1Symbol).isEnabled = true
            findViewById<TextView>(R.id.player2Symbol).isEnabled = true
        }

        findViewById<Button>(R.id.oneButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.oneButton))
        }
        findViewById<Button>(R.id.twoButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.twoButton))
        }
        findViewById<Button>(R.id.threeButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.threeButton))
        }
        findViewById<Button>(R.id.fourButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.fourButton))
        }
        findViewById<Button>(R.id.fiveButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.fiveButton))
        }
        findViewById<Button>(R.id.sixButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.sixButton))
        }
        findViewById<Button>(R.id.sevenButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.sevenButton))
        }
        findViewById<Button>(R.id.eightButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.eightButton))
        }
        findViewById<Button>(R.id.nineButton).setOnClickListener{
            updateTheBoard(findViewById<Button>(R.id.nineButton))
        }
    }

    fun isGame() : String {
        if(ticTacToeArray[1] == ticTacToeArray[2] &&  ticTacToeArray[1]==ticTacToeArray[3]){
            return ticTacToeArray[1]
        }

        if(ticTacToeArray[4] == ticTacToeArray[5] &&  ticTacToeArray[4]==ticTacToeArray[6]){
            return ticTacToeArray[4]
        }

        if(ticTacToeArray[7] == ticTacToeArray[8] &&  ticTacToeArray[7]==ticTacToeArray[9]){
            return ticTacToeArray[7]
        }

        if(ticTacToeArray[1] == ticTacToeArray[4] &&  ticTacToeArray[1]==ticTacToeArray[7]){
            return ticTacToeArray[1]
        }

        if(ticTacToeArray[2] == ticTacToeArray[5] &&  ticTacToeArray[2]==ticTacToeArray[8]){
            return ticTacToeArray[2]
        }

        if(ticTacToeArray[3] == ticTacToeArray[6] &&  ticTacToeArray[3]==ticTacToeArray[9]){
            return ticTacToeArray[3]
        }

        if(ticTacToeArray[1] == ticTacToeArray[5] &&  ticTacToeArray[1]==ticTacToeArray[9]){
            return ticTacToeArray[1]
        }

        if(ticTacToeArray[3] == ticTacToeArray[5] &&  ticTacToeArray[3]==ticTacToeArray[7]){
            return ticTacToeArray[3]
        }
        return ""
    }

    fun  updateTheBoard(btn : Button){
        btn.isClickable = false
        var btnid = btn.tag.toString().toInt()
        if(counter%2==0) {
            btn.text = player2Symbol
            findViewById<TextView>(R.id.ticTacToeHeadertextView).text = "Now " + findViewById<TextView>(R.id.player1Name).text.toString() + "'s Turn"
        }  else {
            btn.text = player1Symbol
            findViewById<TextView>(R.id.ticTacToeHeadertextView).text =  "Now " + findViewById<TextView>(R.id.player2Name).text.toString() + "'s Turn"

        }
        ticTacToeArray[btnid] = btn.text.toString()

        counter += 1

        if(counter>3){
            var isItGame = isGame()
            if(isItGame == player1Symbol){
                alertPopUp("WELL DONE",findViewById<TextView>(R.id.player1Name).text.toString() + " you WON!!")
                findViewById<Button>(R.id.playAgainButton).visibility = View.VISIBLE
                findViewById<TextView>(R.id.ticTacToeHeadertextView).text = findViewById<TextView>(R.id.player1Name).text.toString()  + " WON!"
                updateAsGameOver()
            }
            if(isItGame == player2Symbol){
                alertPopUp("WELL DONE",findViewById<TextView>(R.id.player2Name).text.toString() + " you WON!!")
                findViewById<Button>(R.id.playAgainButton).visibility = View.VISIBLE
                findViewById<TextView>(R.id.ticTacToeHeadertextView).text = findViewById<TextView>(R.id.player2Name).text.toString()  + " WON!"
                updateAsGameOver()
            }
            if(counter == 10 && isItGame == "" ){
                updateAsGameOver()
                alertPopUp("Info"," No One won the Game...")
                findViewById<Button>(R.id.playAgainButton).visibility = View.VISIBLE
                findViewById<TextView>(R.id.ticTacToeHeadertextView).text = "Tic Tac Toe"
            }
        }
    }

    fun updateAsGameOver(){
        findViewById<Button>(R.id.oneButton).isClickable = false
        findViewById<Button>(R.id.twoButton).isClickable = false
        findViewById<Button>(R.id.threeButton).isClickable = false
        findViewById<Button>(R.id.fourButton).isClickable = false
        findViewById<Button>(R.id.fiveButton).isClickable = false
        findViewById<Button>(R.id.sixButton).isClickable = false
        findViewById<Button>(R.id.sevenButton).isClickable = false
        findViewById<Button>(R.id.eightButton).isClickable = false
        findViewById<Button>(R.id.nineButton).isClickable = false
    }

    fun  setTheBoard(){
        counter = 1
        ticTacToeArray = arrayListOf("TTT", "", "", "", "", "", "", "", "","")
        findViewById<TableLayout>(R.id.ticTacToeTableLayout).visibility = View.INVISIBLE
        findViewById<Button>(R.id.startGameButton).visibility = View.VISIBLE
        findViewById<Button>(R.id.oneButton).isClickable = true
        findViewById<Button>(R.id.oneButton).text = "1"
        findViewById<Button>(R.id.twoButton).isClickable = true
        findViewById<Button>(R.id.twoButton).text = "2"
        findViewById<Button>(R.id.threeButton).isClickable = true
        findViewById<Button>(R.id.threeButton).text = "3"
        findViewById<Button>(R.id.fourButton).isClickable = true
        findViewById<Button>(R.id.fourButton).text = "4"
        findViewById<Button>(R.id.fiveButton).isClickable = true
        findViewById<Button>(R.id.fiveButton).text = "5"
        findViewById<Button>(R.id.sixButton).isClickable = true
        findViewById<Button>(R.id.sixButton).text = "6"
        findViewById<Button>(R.id.sevenButton).isClickable = true
        findViewById<Button>(R.id.sevenButton).text = "7"
        findViewById<Button>(R.id.eightButton).isClickable = true
        findViewById<Button>(R.id.eightButton).text = "8"
        findViewById<Button>(R.id.nineButton).isClickable = true
        findViewById<Button>(R.id.nineButton).text = "9"
        findViewById<Button>(R.id.playAgainButton).visibility = View.INVISIBLE
    }

    fun alertPopUp(title : String, message :String){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
        dialog.setMessage(message)
        dialog.setTitle(title)
        val alertDialog = dialog.create()
        alertDialog.show()
    }

    fun checkplayers(): Boolean {
        if(findViewById<TextView>(R.id.player1Name).text.toString().isEmpty() ||
            findViewById<TextView>(R.id.player2Name).text.toString().isEmpty()) {
            alertPopUp( "Alert","Please provide players' name to proceed")
            return false
        }

        if(findViewById<TextView>(R.id.player1Symbol).text.toString().isNotEmpty()) {
            player1Symbol = findViewById<TextView>(R.id.player1Symbol).text.toString()
        }

        if(findViewById<TextView>(R.id.player2Symbol).text.toString().isNotEmpty()) {
            player2Symbol = findViewById<TextView>(R.id.player2Symbol).text.toString()
        }
        return true
    }
}