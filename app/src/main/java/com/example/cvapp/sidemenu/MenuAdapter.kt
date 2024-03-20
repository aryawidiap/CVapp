package com.example.cvapp.sidemenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.R

class MenuAdapter() : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private var mData : List<MenuItem> = listOf()
    lateinit var listener : Callback
    constructor(mData : List<MenuItem>, listener : Callback) : this() {
        this.mData = mData
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MenuViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount() : Int {
        return 0
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon : ImageView
        var isSelected : ImageView
        init {
            icon = itemView.findViewById(R.id.item_menu_icon)
            isSelected = itemView.findViewById(R.id.item_menu_selected)
            itemView.setOnClickListener { listener.onSideMenuItemClick(adapterPosition) }
        }
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.icon.setImageResource(mData[position].icon)
        if(mData[position].isSelected){
            holder.isSelected.visibility = View.VISIBLE
        } else {
            holder.isSelected.visibility = View.GONE
        }
    }
}