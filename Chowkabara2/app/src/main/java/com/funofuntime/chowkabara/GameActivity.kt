package com.funofuntime.chowkabara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameActivity : AppCompatActivity() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: IconAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        var chowkaBaraBoard = ChowkaBaraBoard()

       var player_Icon =  getString(R.string.carrotIcon).toString() //chowkaBaraBoard.players[0].btnIcon.toString()
        var icons: ArrayList<String> = arrayListOf()
        var cellId: String = ""
        var resID: Int = 0

        for (r in 1..5){
            for (c in 1..5) {
                cellId = "cell$r$c"
                resID = resources.getIdentifier(cellId, "id", packageName)
                for(i in 1..16){
                    icons.add(player_Icon)
                }
                loadIcons(icons,resID,cellId)
            }
        }
        println("hello after settign text")


    }

    override fun onResume() {
        super.onResume()
    }

    fun loadIcons(icons: ArrayList<String>, resID : Int, cellId: String){
        var recyclerView = findViewById<RecyclerView>(resID)
        layoutManager = GridLayoutManager(this, 4)
        recyclerView.layoutManager = layoutManager
        adapter = IconAdapter(icons, cellId)
        recyclerView.adapter = adapter
    }

}