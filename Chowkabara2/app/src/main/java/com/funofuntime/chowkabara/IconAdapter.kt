package com.funofuntime.chowkabara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IconAdapter(val icons: ArrayList<Icon>) :
        RecyclerView.Adapter<IconAdapter.IconHolder>() {

    class IconHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view: View = v
        lateinit var icon: Icon

        init {
            v.setOnClickListener(this)
        }

        fun bindIcon(icon: Icon) {
            this.icon = icon
            view.findViewById<TextView>(R.id.lconTextView).text = icon.icon
        }

        override fun onClick(v: View?) {
                (view.context as GameActivity).updateBoard(icon, adapterPosition)
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        return IconHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.icon, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return icons.count()
    }

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        val icon = icons[position]
        holder.bindIcon(icon)
    }
}