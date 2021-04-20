package com.funofuntime.funofuntimes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class ActivitiesSelectorAdapter(val activities : List<Button>) :RecyclerView.Adapter<ActivitiesSelectorAdapter.ActivityHolder>() {

    class ActivityHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        var view = v
        lateinit var activity : Button

        fun bindActivity(activity : Button){
            this.activity = activity
            view.findViewById<Button>(R.id.activityButton).text = activity.text
        }

        override fun onClick(v: View?) {
            val intent = Intent(v?.context, view.findViewById<Button>(R.id.activityButton).tag::class.java)
            ContextCompat.startActivity(view.context, intent, null)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
        return ActivityHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_row, parent, false))

    }

    override fun getItemCount(): Int {
        return activities.count()
    }

    override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
        holder.bindActivity(activities[position])
    }
}
