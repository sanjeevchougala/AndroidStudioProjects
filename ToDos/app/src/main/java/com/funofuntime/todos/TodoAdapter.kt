package com.funofuntime.todos

import android.content.Intent
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(val todos: List<String>) : RecyclerView.Adapter<TodoAdapter.ToDoHolder>() {

    class ToDoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        var view : View = v
        var title : String = ""

        init{
            v.setOnClickListener(this)
        }

        fun bindTodo(title: String){
            this.title = title
            view.findViewById<TextView>(R.id.todoTextView).text = title
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteTodoActivity::class.java)
            intent.putExtra("todoToUpdate", title)
            startActivity(view.context,intent,null)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todorow, parent, false))
    }

    override fun getItemCount(): Int {
        return todos.count()
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val title = todos[position]
        holder.bindTodo(title)
    }
}