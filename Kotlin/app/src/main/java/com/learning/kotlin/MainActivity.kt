package com.learning.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forloop()
    }

    fun forloop() {
        for(x in 1..10){
            println("hello fro forloop func => x : " + x);
        }
    }
}