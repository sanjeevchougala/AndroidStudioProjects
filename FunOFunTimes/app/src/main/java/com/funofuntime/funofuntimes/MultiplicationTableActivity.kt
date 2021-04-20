package com.funofuntime.funofuntimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MultiplicationTableActivity : AppCompatActivity() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: MultiplicationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication_table)


        findViewById<Button>(R.id.homeButton).setOnClickListener{
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        var recyclerView = findViewById<RecyclerView>(R.id.numTableRecyclerView)
        val numbers: ArrayList<Int> = arrayListOf(1)
        for(index in 2..100){
            numbers.add(index)
        }
        layoutManager = GridLayoutManager(this,5)
        recyclerView.layoutManager = layoutManager
        adapter = MultiplicationAdapter(numbers)
        recyclerView.adapter = adapter
    }


}