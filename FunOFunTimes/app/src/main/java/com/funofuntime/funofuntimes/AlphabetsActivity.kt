package com.funofuntime.funofuntimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class AlphabetsActivity : AppCompatActivity() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: AlphabetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabets)


        findViewById<Button>(R.id.homeButton).setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        var alphabets : String ="abcdefghijklmnopqrstuvwxyz"
        var letters: ArrayList<String> = arrayListOf()

        for(index in 0..25){
            letters.add(alphabets[index].toString())
        }
        loadAlphabets(letters)

        findViewById<Button>(R.id.upperAZButton).setOnClickListener {
            letters.clear()
            for(index in 0..25){
                letters.add(alphabets[index].toString().toUpperCase())
            }
            loadAlphabets(letters)
        }

        findViewById<Button>(R.id.lowerAZButton).setOnClickListener {
            letters.clear()
            for(index in 0..25){
                letters.add(alphabets[index].toString())
            }
            loadAlphabets(letters)
        }

        findViewById<Button>(R.id.bothAZButton).setOnClickListener {
            letters.clear()
            for(index in 0..25){
                letters.add(alphabets[index].toString().toUpperCase() + alphabets[index].toString())
            }
            loadAlphabets(letters)
        }

        findViewById<Button>(R.id.getLetterButton).setOnClickListener {
            val rand = Random().nextInt(25) + 1
            findViewById<TextView>(R.id.alphaTextView).text = letters[rand]
        }

    }

    fun loadAlphabets(letters: ArrayList<String>){
        var recyclerView = findViewById<RecyclerView>(R.id.alphabetRecyclerView)
        layoutManager = GridLayoutManager(this, 5)
        recyclerView.layoutManager = layoutManager
        adapter = AlphabetAdapter(letters)
        recyclerView.adapter = adapter
    }
}