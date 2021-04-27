package com.funofuntime.chowkabara

import android.app.AlertDialog
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                cellId = it.icons[0].cellId
                resID = resources.getIdentifier(cellId, "id", packageName)
                ChowkaBaraBoard.cells[cellId]?.let { it1 -> loadIcons(it1, resID) }
                if(ChowkaBaraBoard.currentPlayer == 0){
                    ChowkaBaraBoard.currentPlayer = it.id
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

    fun messagePopUp(title : String, message :String){
        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
        dialog.setMessage(message)
        dialog.setTitle(title)
        val alertDialog = dialog.create()
        alertDialog.show()
    }

    fun setNextPlayer() {
        ChowkaBaraBoard.players.filter { player : Player -> player.id != ChowkaBaraBoard.currentPlayer}.forEach(){
            if (ChowkaBaraBoard.currentPlayer == 4) {
                if(it.playing) {
                    ChowkaBaraBoard.currentPlayer = it.id
                    return
                }
            } else {
                if(it.id > ChowkaBaraBoard.currentPlayer) {
                    ChowkaBaraBoard.currentPlayer = it.id
                    return
                }
            }

        }
        messagePopUp("Info", "Looks like all other players have moved their icons to cell33. Game Over!")

    }
    fun updateBoard(icon: Icon, adapterPosition: Int){
        println("Clicked icon is : ${icon.icon}")
        println("Clicked icon's tag is : ${icon.iconTag}")
        println("Clicked icon is in cell  : ${icon.cellId}")
        println("current played ID is  : ${ChowkaBaraBoard.currentPlayer}")
        var recyclerView = findViewById<RecyclerView>(resources.getIdentifier(icon.cellId, "id", packageName))

        ChowkaBaraBoard.players.map { player : Player ->
             if(player.id ==  ChowkaBaraBoard.currentPlayer) {
                 println("inside matching : ${player.name} and id is ${player.id}")
                 if (player.icons[0]?.icon == icon.icon) {
                     if(moveIcon(player, icon, adapterPosition)){
                         recyclerView.adapter?.notifyItemRemoved(adapterPosition)
                         setNextPlayer()
                         ChowkaBaraBoard.diceRolled = false
                         ChowkaBaraBoard.diceValue = 0
                         findViewById<Button>(R.id.diceButton).visibility = View.VISIBLE
                         findViewById<Button>(R.id.passTurnButton).visibility = View.INVISIBLE
                         findViewById<ImageView>(R.id.diceImageView).visibility = View.INVISIBLE
                         return
                     }
                 } else {
                     messagePopUp("Alert", "Only allowed to click ${player.name}'s icon : ${player.icons[0]?.icon}. If not able to move any icons pass the turn to next player")
                     findViewById<Button>(R.id.passTurnButton).visibility = View.VISIBLE
                 }
                 return
             }
        }
    }

    fun  moveIcon(player : Player, icon : Icon, adapterPosition : Int) : Boolean {
        var cellIdNum = icon.cellId.substring(4)

        println("cellIdNum : $cellIdNum")
        var currentPosInBtnPath = ChowkaBaraBoard.btnPath[player.id.toString()]?.indexOf(cellIdNum)
        println("currentPosinBtnPath :$currentPosInBtnPath")
        var destinationCellId = ChowkaBaraBoard.diceValue.toInt() + currentPosInBtnPath!!
        var destinationCell = "cell" + ChowkaBaraBoard.btnPath[player.id.toString()]?.elementAt(destinationCellId)
        println("destinationCell :$destinationCell")

        if(ChowkaBaraBoard.innerCells.contains(destinationCell.substring(4)) && !player.hasPasstoInnerLoop){
            messagePopUp("Alert", "You do not have pass to enter inner loop yet, try moving another icon of yours. If not able to move any icons pass the turn to next player")
            findViewById<Button>(R.id.passTurnButton).visibility = View.VISIBLE
            return false
        } else {
            //check if another player's icon is in destination cell (which i snot home cell). if yes then move icon back to corresponding player's home cell
            println("icons count in :$destinationCell : ${ChowkaBaraBoard.cells[destinationCell]?.count()}")
            if(!ChowkaBaraBoard.homeCells.contains(destinationCell)  && ChowkaBaraBoard.cells[destinationCell]?.count()!! >0) {
                println("Inside removing icon loop")

                var playerHomeCell = ChowkaBaraBoard.cells[destinationCell]?.elementAt(0)?.homeCell.toString()
                if(icon.homeCell.compareTo(playerHomeCell) == 0){
                    messagePopUp("Info", "You already have your own icon in $destinationCell cell, try moving another icon. If not able to move any icons pass the turn to next player")
                    return false
                }
                ChowkaBaraBoard.cells[destinationCell]?.elementAt(0)?.let { ChowkaBaraBoard.cells[playerHomeCell]?.add(it) }
                ChowkaBaraBoard.cells[destinationCell]?.removeAt(0)
                var recyclerViewforDestCell = findViewById<RecyclerView>(resources.getIdentifier(destinationCell, "id", packageName))
                recyclerViewforDestCell.adapter?.notifyItemRemoved(0)
                ChowkaBaraBoard.cells[playerHomeCell]?.let { it1 -> loadIcons(it1, resources.getIdentifier(playerHomeCell, "id", packageName))}
                player.hasPasstoInnerLoop = true
            }
            println("icons count in :$destinationCell before move : ${ChowkaBaraBoard.cells[destinationCell]?.count()}")

            ChowkaBaraBoard.cells[destinationCell]?.add(icon)
            ChowkaBaraBoard.cells[destinationCell]?.let { it1 -> loadIcons(it1, resources.getIdentifier(destinationCell, "id", packageName))}
            ChowkaBaraBoard.cells[icon.cellId]?.removeAt(adapterPosition)
            icon.cellId = destinationCell
            return true
        }
        return false
    }

}