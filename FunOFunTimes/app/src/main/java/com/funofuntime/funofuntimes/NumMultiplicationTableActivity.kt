package com.funofuntime.funofuntimes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class NumMultiplicationTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_multiplication_table)

        findViewById<Button>(R.id.backButton).setOnClickListener() {
            finish()
        }

        findViewById<Button>(R.id.homeButton).setOnClickListener() {
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()

        var num : Int? = intent.extras?.getInt("number")
        if (num != null) {
            if(num > 0) {
                findViewById<TextView>(R.id.oneTextView).text = num.toString() + " X 1 = " + (num * 1).toString()
                findViewById<TextView>(R.id.twoTextView).text = num.toString() + " X 2 = " + (num * 2).toString()
                findViewById<TextView>(R.id.threeTextView).text = num.toString() + " X 3 = " + (num * 3).toString()
                findViewById<TextView>(R.id.fourTextView).text = num.toString() + " X 4 = " + (num * 4).toString()
                findViewById<TextView>(R.id.fiveTextView).text = num.toString() + " X 5 = " + (num * 5).toString()
                findViewById<TextView>(R.id.sixTextView).text = num.toString() + " X 6 = " + (num * 6).toString()
                findViewById<TextView>(R.id.sevenTextView).text = num.toString() + " X 7 = " + (num * 7).toString()
                findViewById<TextView>(R.id.eightTextView).text = num.toString() + " X 8 = " + (num * 8).toString()
                findViewById<TextView>(R.id.nineTextView).text = num.toString() + " X 9 = " + (num * 9).toString()
                findViewById<TextView>(R.id.tenTextView).text = num.toString() + " X 10 = " + (num * 10).toString()
            }
        }
    }
}

//class IconFocusActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_icon_focus)
//    }
//
//    override fun onStart(){
//        super.onStart()
//        val iconToFocus = intent.extras?.getString("icon")
//        var iconTextView = findViewById<TextView>(R.id.iconTextView)
//        iconTextView.text= iconToFocus
//    }
//}