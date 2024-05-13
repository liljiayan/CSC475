package com.project.foodrecipes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.foodrecipes.R
import com.project.foodrecipes.model.ModelMain

class MainAdapter(
    private val mContext: Context,
    private val items: List<ModelMain>,
    private val onSelectData: OnSelectData
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface OnSelectData {
        fun onSelected(modelMain: ModelMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_categories, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        // Get Image
        Glide.with(mContext)
            .load(data.strCategoryThumb)
            .placeholder(R.drawable.ic_food_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgCategory)

        holder.tvCategory.text = data.strCategory
        holder.cvCategory.setOnClickListener { onSelectData.onSelected(data) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Class Holder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val cvCategory: CardView = itemView.findViewById(R.id.cvCategory)
        val imgCategory: ImageView = itemView.findViewById(R.id.imgCategory)
    }
}