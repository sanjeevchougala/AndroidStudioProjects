package com.funofuntime.chowkabara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IconAdapter (val buttons : ArrayList<String>, val cellId : String) :
        RecyclerView.Adapter<IconAdapter.IconHolder>() {

    class IconHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view: View = v
        var icon: String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindltr(ltr: String, cellId: String) {
            this.icon = ltr
            view.findViewById<TextView>(R.id.lconTextView).text = ltr
            view.findViewById<TextView>(R.id.lconTextView).tag = cellId
        }

        override fun onClick(v: View?) {
//            val focusIntent = Intent(view.context, NumMultiplicationTableActivity::class.java)
//            focusIntent.putExtra("letter", ltr)
//            ContextCompat.startActivity(view.context, focusIntent, null)
//            view.findViewById<TextView>(R.id.alphaTextView).text = ltr
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        return IconHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.icon, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return buttons.count()
    }

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        val icon = buttons[position]
        holder.bindltr(icon, cellId)
    }

}