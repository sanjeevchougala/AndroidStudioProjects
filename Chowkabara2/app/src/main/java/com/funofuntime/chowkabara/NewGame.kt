package com.funofuntime.chowkabara

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        findViewById<Button>(R.id.confirmPlayersButton).setOnClickListener(){
            checkPlayers()
        }

        findViewById<Button>(R.id.startGameButton).setOnClickListener(){
            val intent = Intent(this, GameActivity ::class.java)
            startActivity(intent)

        }

        findViewById<Button>(R.id.homeButton).setOnClickListener{
            finish()
        }
    }

    fun checkPlayers(){
        var players : Int = 0
        var playername : String =""
        var playeIcon : String =""
        var resID: Int = 0
        var playingStatus : String = ""
        var player : Player

        for(i in 1..4){
            playername = "player$i" + "Name"
            resID = resources.getIdentifier(playername, "id", packageName)
            if (findViewById<TextView>(resID).text.isNotEmpty()){
                players++
            }
        }
        if(players >=2){
            println("2 players provided")
            var chowkaBaraBoard = ChowkaBaraBoard()
            findViewById<Button>(R.id.startGameButton).visibility = View.VISIBLE
            findViewById<Button>(R.id.confirmPlayersButton).visibility = View.INVISIBLE
            for(i in 1..4){
                playername = "player$i" + "Name"
                resID = resources.getIdentifier(playername, "id", packageName)
                playername = findViewById<TextView>(resID).text.toString()
                playeIcon = "player$i" + "Icon"
                resID = resources.getIdentifier(playeIcon, "id", packageName)
                playeIcon = findViewById<TextView>(resID).text.toString()

                if (playeIcon.isEmpty()){
                    playeIcon = findViewById<TextView>(resID).hint.toString()
                }

                player = Player(playername, playeIcon)
                player.setPlayingTrue()
                if (playername.isEmpty()){
                    player.setPlayingFalse()
                    playingStatus = "player$i" + "Status"
                    resID = resources.getIdentifier(playingStatus, "id", packageName)
                    findViewById<TextView>(resID).text = "Not Playing.."
                } else {
                    player.setPlayingTrue()
                    playingStatus = "player$i" + "Status"
                    resID = resources.getIdentifier(playingStatus, "id", packageName)
                    findViewById<TextView>(resID).text = "Playing.."
                }

                chowkaBaraBoard.addPlayer(player)
                println("Name: $playername and Icon: $playeIcon")
            }
        } else {
            alertPopUp( "Alert","Please provide at least 2 players' name to proceed")
        }
    }

    fun alertPopUp(title : String, message :String){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
        dialog.setMessage(message)
        dialog.setTitle(title)
        val alertDialog = dialog.create()
        alertDialog.show()
    }
}