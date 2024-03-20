package com.example.cvapp.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cvapp.R

class EducationAdapter : RecyclerView.Adapter<EducationAdapter.EducationViewHolder> {
    private var mdata : List<EducationItem>? = null
    constructor(mdata: List<EducationItem>){
        this.mdata = mdata
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_education,parent,false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.tvTitle.text = mdata?.get(position)?.title
        holder.tvDescription.text = mdata?.get(position)?.description
    }

    override fun getItemCount(): Int {
        return mdata?.size!!
    }

    class EducationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle : TextView = itemView.findViewById(R.id.item_education_title)
        val tvDescription : TextView = itemView.findViewById(R.id.item_education_desc)


    }
}