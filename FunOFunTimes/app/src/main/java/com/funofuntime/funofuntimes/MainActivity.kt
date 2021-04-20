package com.funofuntime.funofuntimes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: ActivitiesSelectorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.playAddSubButton).setOnClickListener(){
            val intent = Intent(this, AddSub ::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.playNumPracticeButton).setOnClickListener() {
            val intent = Intent(this, NumPractice::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.playTicTacToeButton).setOnClickListener() {
            val intent = Intent(this, TicTacToe::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.playMultiplicationButton).setOnClickListener() {
            val intent = Intent(this, MultiplicationTableActivity::class.java)
            startActivity(intent)
        }

    }

//    override fun onResume() {
//        super.onResume()
//       // updateRecycler()
//    }

//    fun updateRecycler() {
//        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
//        var activities =  prefs.getStringSet(getString(R.string.ACTIVITIES), setOf())?.toMutableSet()
//
//        if(activities == null){
//            activities = mutableSetOf("AddSub", "NumPractice","Tic-Tac-Toe")
//        }
//        layoutManager = GridLayoutManager(this,3)
//        recyclerView.layoutManager = layoutManager
//        adapter = ActivitiesSelectorAdapter((listOf(findViewById<Button>(R.id.playAddSubButton),findViewById<Button>(R.id.playNumPracticeButton))))
//        recyclerView.adapter = adapter
//    }
}