package com.funofuntime.todos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class CreateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        var saveButton = findViewById<Button>(R.id.saveButton)
        var imptChecked = findViewById<CheckBox>(R.id.importantCheckBox)
        var todo = findViewById<TextView>(R.id.namePlainText)

        saveButton.setOnClickListener(){
            var title = ""

            if(imptChecked.isChecked){
                title = "! "
            }
            title += todo.text.toString()

            var prefs = getSharedPreferences( getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)

            var currentTodos =  prefs.getStringSet(getString(R.string.CURRENT_TODOS), setOf())?.toMutableSet()

            if(currentTodos == null){
                currentTodos = mutableSetOf(title)
            } else {
                currentTodos.add(title)
            }
            prefs.edit().putStringSet(getString(R.string.CURRENT_TODOS), currentTodos).apply()

            finish()
        }


    }
}