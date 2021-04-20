package com.funofuntime.icondictionary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class IconAdapter(val icons : ArrayList<String> ) : RecyclerView.Adapter<IconAdapter.TextHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return icons.count()
    }

    override fun onBindViewHolder(holder: IconAdapter.TextHolder, position: Int) {
        val icon = icons[position]
        holder.bindIcon(icon)
    }

    class TextHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view : View = v
        var icon : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindIcon(icon:String){
            this.icon = icon
            view.findViewById<TextView>(R.id.iconTextView).text = icon
        }

        override fun onClick(v: View?) {
            val focusIntent = Intent(view.context, IconFocusActivity :: class.java)
            focusIntent.putExtra("icon", icon)
            startActivity(view.context, focusIntent, null)
        }

    }
}