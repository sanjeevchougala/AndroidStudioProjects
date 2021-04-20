package com.funofuntime.icondictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IconFocusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_focus)
    }

    override fun onStart(){
        super.onStart()
        val iconToFocus = intent.extras?.getString("icon")
        var iconTextView = findViewById<TextView>(R.id.iconTextView)
        iconTextView.text= iconToFocus
    }
}