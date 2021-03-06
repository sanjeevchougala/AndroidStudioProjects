package com.funofuntime.chowkabara

import android.accounts.Account
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.random.Random


class GameActivity : AppCompatActivity() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: IconAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        
        var cellId: String = ""
        var resID: Int = 0

        ChowkaBaraBoard.players.forEach(){
            if(it.playing) {
                it.icons.forEach(){ icon: Icon ->
                    cellId = icon.cellId
                    resID = resources.getIdentifier(cellId, "id", packageName)
                    ChowkaBaraBoard.cells[cellId]?.let { it1 -> loadIcons(it1, resID) }
                }
                if(ChowkaBaraBoard.currentPlayer == 0 || ChowkaBaraBoard.currentPlayer == it.id){
                    ChowkaBaraBoard.currentPlayer = it.id
                    findViewById<TextView>(R.id.currentPlayerTextView).text = "Current Turn: ${it.name} :: ${it.btnIcon}"
                }
           }
        }

        var rollDice = findViewById<Button>(R.id.diceButton)
        var dice = findViewById<ImageView>(R.id.diceImageView)
        dice.visibility = View.INVISIBLE

        rollDice.setOnClickListener(){
            val rotate = RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF, 2.0f, Animation.RELATIVE_TO_SELF, 2.0f)
            rotate.duration = 500
            rotate.interpolator = LinearInterpolator()
            rotate.repeatCount = 2
            rotate.repeatMode = 2

            for (imageId in 1..6) {
                dice.setImageResource(R.drawable.dice)
                if(imageId ==1){
                    dice.setImageResource(R.drawable.dice1)
                    dice.startAnimation(rotate)
                }
                if(imageId ==2){
                    dice.setImageResource(R.drawable.dice2)
                    dice.startAnimation(rotate)
                }
                if(imageId ==3){
                    dice.setImageResource(R.drawable.dice3)
                    dice.startAnimation(rotate)
                }
                if(imageId ==4){
                    dice.setImageResource(R.drawable.dice4)
                    dice.startAnimation(rotate)
                }
                if(imageId ==5){
                    dice.setImageResource(R.drawable.dice5)
                    dice.startAnimation(rotate)
                }
                if(imageId ==6){
                    dice.setImageResource(R.drawable.dice6)
                    dice.startAnimation(rotate)
                }
            }
            val rand = Random.nextInt(6)  + 1
            println("rand : $rand")
            ChowkaBaraBoard.diceValue = rand
            ChowkaBaraBoard.diceRolled = true
            rollDice.visibility = View.INVISIBLE
            dice.visibility = View.VISIBLE
           if(rand ==1){
               dice.setImageResource(R.drawable.dice1)
           }
            if(rand ==2){
                dice.setImageResource(R.drawable.dice2)
            }
            if(rand ==3){
                dice.setImageResource(R.drawable.dice3)
            }
            if(rand ==4){
                dice.setImageResource(R.drawable.dice4)
            }
            if(rand ==5){
                dice.setImageResource(R.drawable.dice5)
            }
            if(rand ==6){
                dice.setImageResource(R.drawable.dice6)
            }
        }

        findViewById<Button>(R.id.passTurnButton).setOnClickListener() {
            findViewById<Button>(R.id.passTurnButton).visibility = View.INVISIBLE
            setNextPlayer()
            ChowkaBaraBoard.diceRolled = false
            ChowkaBaraBoard.diceValue = 0
            rollDice.visibility = View.VISIBLE
            dice.visibility = View.INVISIBLE
        }

        findViewById<Button>(R.id.startNewGameButton).setOnClickListener(){
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    fun loadIcons(icons: ArrayList<Icon>, resID: Int){
        var recyclerView = findViewById<RecyclerView>(resID)
        layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        adapter = IconAdapter(icons)
        recyclerView.adapter = adapter
    }

    fun messagePopUp(title: String, message: String){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
        dialog.setMessage(message)
        dialog.setTitle(title)
        val alertDialog = dialog.create()
        alertDialog.show()
    }

    fun setNextPlayer() {
        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        val prefsEditor: SharedPreferences.Editor = prefs.edit()

        val gson = Gson()
        val payersJson = gson.toJson(ChowkaBaraBoard.players)
        prefsEditor.putString(getString(R.string.CURRENT_PLAYERS_STATUS), payersJson)

        var pId : Int = 0
        //println("next player: ")
        ChowkaBaraBoard.players.forEach(){
            if(!it.completedtheGame){
                //println("checking next player: ${it.id} ${it.name} playing: ${it.playing}")
                if(it.playing  ) {
                    if (it.id > ChowkaBaraBoard.currentPlayer) {
                        ChowkaBaraBoard.currentPlayer = it.id
                        findViewById<TextView>(R.id.currentPlayerTextView).text = "Current Turn: ${it.name} :: ${it.btnIcon}"
                        prefsEditor.putString(getString(R.string.LAST_PLAYED_PLAYERID), ChowkaBaraBoard.currentPlayer.toString())
                        prefsEditor.apply()
                        return
                    }
                    if(pId == 0 && it.id != ChowkaBaraBoard.currentPlayer){
                        pId = it.id
                        findViewById<TextView>(R.id.currentPlayerTextView).text = "Current Turn: ${it.name} :: ${it.btnIcon}"
                       // println("pId: $pId")
                    }
                }
                if (it.id == 4) {
                    //println("it 4 : ${it.playing}")
                    if(it.playing && it.id != ChowkaBaraBoard.currentPlayer) {
                        ChowkaBaraBoard.currentPlayer = it.id
                        findViewById<TextView>(R.id.currentPlayerTextView).text = "Current Turn: ${it.name} :: ${it.btnIcon}"
                        prefsEditor.putString(getString(R.string.LAST_PLAYED_PLAYERID), ChowkaBaraBoard.currentPlayer.toString())
                        prefsEditor.apply()
                        return
                    } else if(pId!=0){
                        //println("inside 4 returning p : $pId")
                        ChowkaBaraBoard.currentPlayer = pId
                        prefsEditor.putString(getString(R.string.LAST_PLAYED_PLAYERID), ChowkaBaraBoard.currentPlayer.toString())
                        prefsEditor.apply()
                        return
                    }
                }
            }
        }
        prefsEditor.putString(getString(R.string.LAST_PLAYED_PLAYERID), ChowkaBaraBoard.currentPlayer.toString())
        prefsEditor.apply()
        messagePopUp("Info", "Looks like all other players have moved their icons to cell33. Game Over!")
        findViewById<Button>(R.id.startNewGameButton).visibility = View.VISIBLE
        findViewById<Button>(R.id.diceButton).visibility = View.INVISIBLE
        return
    }
    fun updateBoard(icon: Icon, adapterPosition: Int){
        var recyclerView = findViewById<RecyclerView>(resources.getIdentifier(icon.cellId, "id", packageName))

        ChowkaBaraBoard.players.map { player: Player ->
            if(player.id ==  ChowkaBaraBoard.currentPlayer) {
                //println("inside matching : ${player.name} and id is ${player.id}")
                if (player.icons[0]?.icon == icon.icon) {
                    if(moveIcon(player, icon, adapterPosition)){
                        recyclerView.adapter?.notifyDataSetChanged() //notifyItemRemoved(adapterPosition)
                        setNextPlayer()
                        ChowkaBaraBoard.diceRolled = false
                        ChowkaBaraBoard.diceValue = 0
                        findViewById<Button>(R.id.diceButton).visibility = View.VISIBLE
                        findViewById<Button>(R.id.passTurnButton).visibility = View.INVISIBLE
                        findViewById<ImageView>(R.id.diceImageView).visibility = View.INVISIBLE
                        return
                    }
                    findViewById<Button>(R.id.passTurnButton).visibility = View.VISIBLE
                } else {
                    messagePopUp("Alert", "Only allowed to click ${player.name}'s icon : ${player.icons[0]?.icon}. If not able to move any icons pass the turn to next player")
                    findViewById<Button>(R.id.passTurnButton).visibility = View.VISIBLE
                }
                return
            }
        }
    }

    fun  moveIcon(player: Player, icon: Icon, adapterPosition: Int) : Boolean {
        var cellIdNum = icon.cellId.substring(4)

        //println("cellIdNum : $cellIdNum")
        var currentPosInBtnPath = ChowkaBaraBoard.btnPath[player.id.toString()]?.indexOf(cellIdNum)
        //println("currentPosinBtnPath :$currentPosInBtnPath")
        var destinationCellId = ChowkaBaraBoard.diceValue.toInt() + currentPosInBtnPath!!
        //println("destinationCellId position :$destinationCellId")

        if(destinationCellId > 24){
            messagePopUp("Alert", "Cannot move the selected icon, try moving other icon of your's. If not able to move any other icon, pass the turn to next player")
            return false
        }
        var destinationCell = "cell" + ChowkaBaraBoard.btnPath[player.id.toString()]?.elementAt(destinationCellId)
        println("destinationCell :$destinationCell")

        if(ChowkaBaraBoard.innerCells.contains(destinationCell.substring(4)) && !player.hasPasstoInnerLoop){
            messagePopUp("Alert", "You do not have pass to enter the inner loop yet, try moving another icon of yours. If not able to move any other icon, pass the turn to next player")
            findViewById<Button>(R.id.passTurnButton).visibility = View.VISIBLE
            return false
        } else {
            //check if another player's icon is in destination cell (which i snot home cell). if yes then move icon back to corresponding player's home cell
           if(!ChowkaBaraBoard.homeCells.contains(destinationCell)  && ChowkaBaraBoard.cells[destinationCell]?.count()!! >0) {
                var playerHomeCell = ChowkaBaraBoard.cells[destinationCell]?.elementAt(0)?.homeCell.toString()
                if(icon.homeCell.compareTo(playerHomeCell) == 0){
                    messagePopUp("Info", "You already have your own icon in $destinationCell cell, try moving another icon. If not able to move any other icon, pass the turn to next player")
                    return false
                }
                ChowkaBaraBoard.cells[destinationCell]?.elementAt(0)?.let {
                    ChowkaBaraBoard.cells[playerHomeCell]?.add(it)
                    it.cellId=playerHomeCell

                }
                ChowkaBaraBoard.cells[destinationCell]?.removeAt(0)
                var recyclerViewforDestCell = findViewById<RecyclerView>(resources.getIdentifier(destinationCell, "id", packageName))
                recyclerViewforDestCell.adapter?.notifyDataSetChanged() //notifyItemRemoved(0)
                ChowkaBaraBoard.cells[playerHomeCell]?.let { it1 -> loadIcons(it1, resources.getIdentifier(playerHomeCell, "id", packageName))}
               var recyclerViewforplayerHomeCell = findViewById<RecyclerView>(resources.getIdentifier(playerHomeCell, "id", packageName))
               recyclerViewforplayerHomeCell.adapter?.notifyDataSetChanged()
               player.hasPasstoInnerLoop = true
            }
            ChowkaBaraBoard.cells[destinationCell]?.add(icon)
            ChowkaBaraBoard.cells[destinationCell]?.let { it1 -> loadIcons(it1, resources.getIdentifier(destinationCell, "id", packageName))}
            ChowkaBaraBoard.cells[icon.cellId]?.removeAt(adapterPosition)

            player.icons.forEach(){
                if(it.iconTag == icon.iconTag) it.cellId = destinationCell
            }

            icon.cellId = destinationCell

            if(destinationCell == "cell33"){
                checkPlayerCompletedtheGame(player)
            }
            return true
        }
        return false
    }

    fun checkPlayerCompletedtheGame(player: Player){
        var iconcInPalace = 0
        player.icons.forEach(){
                   if(it.cellId == "cell33") iconcInPalace +=1
        }
        if(iconcInPalace==4) player.completedtheGame = true
    }
}