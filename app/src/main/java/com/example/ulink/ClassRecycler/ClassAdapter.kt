package com.example.ulink.ClassRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ulink.R

class ClassAdapter(private val context: Context) :RecyclerView.Adapter<ClassViewHolder>(){
    var datas : MutableList<ClassData> = mutableListOf<ClassData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.class_item,parent,false)
        return ClassViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bind(datas[position])
    }


}