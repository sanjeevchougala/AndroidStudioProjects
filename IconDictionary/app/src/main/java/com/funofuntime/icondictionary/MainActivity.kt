package com.funofuntime.icondictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var layoutManage :  GridLayoutManager//LinearLayoutManager
    lateinit var adapter: IconAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recycleView = findViewById<RecyclerView>(R.id.recyclerView)

        layoutManage = GridLayoutManager(this,3)//LinearLayoutManager(this)
        recycleView.layoutManager = layoutManage

        adapter = IconAdapter(arrayListOf("👐", "🔥", "🐁🎄🍎️"))
        recycleView.adapter = adapter
    }
}