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
        ChowkaBaraBoard.players.clear()
        ChowkaBaraBoard.clearBoard()

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
        var playerIcon : String =""
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
            println("$players players provided")
            var homeCell : String = ""
            findViewById<Button>(R.id.startGameButton).visibility = View.VISIBLE
            findViewById<Button>(R.id.confirmPlayersButton).visibility = View.INVISIBLE
            for(i in 1..4){
                homeCell = ChowkaBaraBoard.homeCells[i]
                playername = "player$i" + "Name"

                resID = resources.getIdentifier(playername, "id", packageName)
                playername = findViewById<TextView>(resID).text.toString()
                playerIcon = "player$i" + "Icon"
                resID = resources.getIdentifier(playerIcon, "id", packageName)
                playerIcon = findViewById<TextView>(resID).text.toString()

                if (playerIcon.isEmpty()){
                    playerIcon = findViewById<TextView>(resID).hint.toString()
                }

                player = Player(i, playername, playerIcon)
                player.setPlayingTrue()
                if (playername.isEmpty()){
                    player.setPlayingFalse()
                    playingStatus = "player$i" + "Status"
                    resID = resources.getIdentifier(playingStatus, "id", packageName)
                    findViewById<TextView>(resID).text = "Not Playing.."
                } else {
                    player.setPlayingTrue()
                    //add 4 buttons for player
                    player.icons.add(Icon(playerIcon,"p$i"+"1",homeCell,homeCell))
                    player.icons.add(Icon(playerIcon,"p$i"+"2",homeCell,homeCell))
                    player.icons.add(Icon(playerIcon,"p$i"+"3",homeCell,homeCell))
                    player.icons.add(Icon(playerIcon,"p$i"+"4",homeCell,homeCell))

                    if (i == 1) {
                        ChowkaBaraBoard.cells["cell13"]?.add(Icon(playerIcon, "p$i" + "1", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell13"]?.add(Icon(playerIcon, "p$i" + "2", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell13"]?.add(Icon(playerIcon, "p$i" + "3", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell13"]?.add(Icon(playerIcon, "p$i" + "4", homeCell,homeCell))
                    }
                    if (i == 2) {
                        ChowkaBaraBoard.cells["cell31"]?.add(Icon(playerIcon, "p$i" + "1", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell31"]?.add(Icon(playerIcon, "p$i" + "2", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell31"]?.add(Icon(playerIcon, "p$i" + "3", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell31"]?.add(Icon(playerIcon, "p$i" + "4", homeCell,homeCell))

                    }
                    if (i == 3) {
                        ChowkaBaraBoard.cells["cell53"]?.add(Icon(playerIcon, "p$i" + "1", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell53"]?.add(Icon(playerIcon, "p$i" + "2", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell53"]?.add(Icon(playerIcon, "p$i" + "3", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell53"]?.add(Icon(playerIcon, "p$i" + "4", homeCell,homeCell))
                    }
                    if (i == 4) {
                        ChowkaBaraBoard.cells["cell35"]?.add(Icon(playerIcon, "p$i" + "1", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell35"]?.add(Icon(playerIcon, "p$i" + "2", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell35"]?.add(Icon(playerIcon, "p$i" + "3", homeCell,homeCell))
                        ChowkaBaraBoard.cells["cell35"]?.add(Icon(playerIcon, "p$i" + "4", homeCell,homeCell))

                    }
                    playingStatus = "player$i" + "Status"
                    resID = resources.getIdentifier(playingStatus, "id", packageName)
                    findViewById<TextView>(resID).text = "Playing.."
                }
                ChowkaBaraBoard.players.add(player)
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