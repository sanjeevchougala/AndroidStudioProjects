package com.funofuntime.todos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CompleteTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_todo)
        val todo = intent.extras?.getString("todoToUpdate")

        findViewById<TextView>(R.id.todoToUpdatetextView).text = todo

        var updateTodoButton = findViewById<Button>(R.id.updateTodoButton)

        updateTodoButton.setOnClickListener(){
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var currentTodos =  prefs.getStringSet(getString(R.string.CURRENT_TODOS), setOf())?.toMutableSet()

            if(currentTodos == null){
                currentTodos = mutableSetOf("No todo(s) yet")
            }
            currentTodos.remove(todo)
            prefs.edit().putStringSet(getString(R.string.CURRENT_TODOS), currentTodos).apply()

            finish()
        }

        findViewById<Button>(R.id.backButton).setOnClickListener(){
            finish()
        }
    }
}