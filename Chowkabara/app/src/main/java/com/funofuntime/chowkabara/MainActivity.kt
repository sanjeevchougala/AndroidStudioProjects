package com.funofuntime.chowkabara

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.playNewGameButton).setOnClickListener(){
            val intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.howToPlayGameButton).setOnClickListener(){
            val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
            dialog.setMessage("Please read app description for rules and game details!")
            dialog.setTitle("Information:")
            val alertDialog = dialog.create()
            alertDialog.show()
        }

        findViewById<Button>(R.id.resumeGameButton).setOnClickListener(){
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            val gson = Gson()
            val type: Type = object : TypeToken<List<Player?>?>() {}.type
            val playersString: String? = prefs.getString(getString(R.string.CURRENT_PLAYERS_STATUS), "")

            ChowkaBaraBoard.clearBoard()
            ChowkaBaraBoard.currentPlayer = prefs.getString(getString(R.string.LAST_PLAYED_PLAYERID), "")?.toInt() ?: 0

            ChowkaBaraBoard.players.forEach(){
                if(it.playing) {
                    it.icons.forEach(){ icon: Icon ->
                        ChowkaBaraBoard.cells[icon.cellId]?.add(icon)
                    }
                }
            }
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

    }


}