package com.funofuntime.funofuntimes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MultiplicationAdapter(val numbers : ArrayList<Int>) :
    RecyclerView.Adapter<MultiplicationAdapter.MultiplicationHolder>() {

    class MultiplicationHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view : View = v
        var num : Int = 0

        init {
            v.setOnClickListener(this)
        }

        fun bindIcon(num : Int){
            this.num = num
            view.findViewById<TextView>(R.id.numTextView).text = num.toString()
        }

        override fun onClick(v: View?) {
            val focusIntent = Intent(view.context, NumMultiplicationTableActivity :: class.java)
            focusIntent.putExtra("number", num)
            startActivity(view.context, focusIntent, null)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiplicationHolder {
        return MultiplicationHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_multiplication_row, parent, false))
    }

    override fun getItemCount(): Int {
        return numbers.count()
    }

    override fun onBindViewHolder(holder: MultiplicationHolder, position: Int) {
        val num = numbers[position]
        holder.bindIcon(num)
    }
}