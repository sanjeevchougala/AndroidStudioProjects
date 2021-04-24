package com.funofuntime.chowkabara

import android.os.Bundle
import android.os.SystemClock.sleep
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
           }
        }

        var rollDice = findViewById<Button>(R.id.diceButton)
        var dice = findViewById<ImageView>(R.id.diceImageView)
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

    fun updateBoard(icon: Icon, adapterPosition: Int){
        println("Clicked icon is : ${icon.icon}")
        println("Clicked icon's tag is : ${icon.iconTag}")
        println("Clicked icon is in cell  : ${icon.cellId}")
        var recyclerView = findViewById<RecyclerView>(resources.getIdentifier(icon.cellId, "id", packageName))

        if(icon.cellId == "cell13") {
            ChowkaBaraBoard.cells["cell13"]?.removeAt(adapterPosition)
            icon.cellId = "cell35"
            if(ChowkaBaraBoard.cells.containsKey("cell35")) {
                println("Inside before adding to cell35 from cell13")
                ChowkaBaraBoard.cells["cell35"]?.add(icon)
                println("Icons in cell35" + ChowkaBaraBoard.cells["cell35"]?.size)
                ChowkaBaraBoard.cells["cell35"]?.let { it1 -> loadIcons(it1, resources.getIdentifier("cell35", "id", packageName)) }
            } else {
                println("Inside else adding to cell35 from cell13")
                ChowkaBaraBoard.cells["cell35"] = arrayListOf(icon)
                ChowkaBaraBoard.cells["cell35"]?.let { it1 -> loadIcons(it1, resources.getIdentifier("cell35", "id", packageName))}
            }
        }

        if(icon.cellId == "cell31") {
            ChowkaBaraBoard.cells["cell31"]?.removeAt(adapterPosition)
            icon.cellId = "cell35"
            if(ChowkaBaraBoard.cells.containsKey("cell35")) {
                println("Inside before adding to cell35 from cell31")
                ChowkaBaraBoard.cells["cell35"]?.add(icon)
                println("Icons in cell35" + ChowkaBaraBoard.cells["cell35"]?.size)
                ChowkaBaraBoard.cells["cell35"]?.let { it1 -> loadIcons(it1, resources.getIdentifier("cell35", "id", packageName))}
            } else {
                println("Inside else adding to cell35 from cell31")
                ChowkaBaraBoard.cells["cell35"] = arrayListOf(icon)
                ChowkaBaraBoard.cells["cell35"]?.let { it1 -> loadIcons(it1, resources.getIdentifier("cell35", "id", packageName))}
            }
        }
        recyclerView.adapter?.notifyItemRemoved(adapterPosition)
    }

}