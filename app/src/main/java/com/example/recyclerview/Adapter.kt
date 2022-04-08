package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val  items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<Adapter.adapterViewHolder>() {

    var onItemClicked: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterViewHolder {
        val  view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return adapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: adapterViewHolder, position: Int) {
       val  currentItem = items[position]
        holder.titleView.text= currentItem
    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class adapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleView : TextView = itemView.findViewById(R.id.textView)
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        init {
            itemView.setOnClickListener {
                onItemClicked?.invoke(adapterPosition)
            }
        }
    }

    fun updateList(list: ArrayList<String>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}