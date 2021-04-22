package com.funofuntime.chowkabara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.funofuntime.chowkabara.ChowkaBaraBoard

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.playNewGameButton).setOnClickListener(){
            val intent = Intent(this, NewGame ::class.java)
            startActivity(intent)
        }
    }


}