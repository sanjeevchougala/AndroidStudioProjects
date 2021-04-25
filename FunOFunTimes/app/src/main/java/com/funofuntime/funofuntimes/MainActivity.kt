package com.funofuntime.funofuntimes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
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

        findViewById<Button>(R.id.playAtoZButton).setOnClickListener() {
            val intent = Intent(this, AlphabetsActivity::class.java)
            startActivity(intent)
        }
    }
}