package com.example.onbording.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onbording.data.Meal
import com.example.onbording.databinding.OverrowBinding


class OverAdapter():RecyclerView.Adapter<OverAdapter.ViewHolder>() {
   lateinit var onOverItemClick:((Meal)->Unit)
    private val diffutil=object :DiffUtil.ItemCallback<Meal>(){
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal==newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
           return oldItem==newItem
        }
    }
    val differ=AsyncListDiffer(this,diffutil)
  class ViewHolder(val binding:OverrowBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(OverrowBinding.inflate(
          LayoutInflater.from(parent.context),parent,false
      ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data=differ.currentList[position]
        Glide.with(holder.itemView)
            .load(data.strMealThumb)
            .into(holder.binding.overImg)
        holder.itemView.setOnClickListener {

            onOverItemClick.invoke(data)

        }
    }

    override fun getItemCount()=differ.currentList.size


}