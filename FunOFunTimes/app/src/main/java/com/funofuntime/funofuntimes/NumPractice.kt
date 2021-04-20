package com.funofuntime.funofuntimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class NumPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_practice)

        var rollButton = findViewById<Button>(R.id.rollButton)
        var resultsTextView= findViewById<TextView>(R.id.resultsTextView)
        var seekBar = findViewById<SeekBar>(R.id.seekBar)

        rollButton.setOnClickListener(){
            val rand = Random().nextInt(seekBar.progress) + 1
            resultsTextView.text = rand.toString()
        }

        findViewById<Button>(R.id.homeButton1).setOnClickListener{
            finish()
        }
    }
}