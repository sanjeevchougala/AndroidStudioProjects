package com.funofuntime.funofuntimes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter (val letters : ArrayList<String>) :
    RecyclerView.Adapter<AlphabetAdapter.AlphabetHolder>() {

    class AlphabetHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view: View = v
        var ltr: String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindltr(ltr: String) {
            this.ltr = ltr
            view.findViewById<TextView>(R.id.ltrTextView).text = ltr
        }

        override fun onClick(v: View?) {
//            val focusIntent = Intent(view.context, NumMultiplicationTableActivity::class.java)
//            focusIntent.putExtra("letter", ltr)
//            ContextCompat.startActivity(view.context, focusIntent, null)
//            view.findViewById<TextView>(R.id.alphaTextView).text = ltr
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetHolder {
        return AlphabetHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_alphabet, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return letters.count()
    }

    override fun onBindViewHolder(holder: AlphabetHolder, position: Int) {
        val num = letters[position]
        holder.bindltr(num)
    }

}