package com.kareemdev.tourismapps.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kareemdev.tourismapps.R
import com.kareemdev.tourismapps.core.data.source.local.entity.TourismEntity
import com.kareemdev.tourismapps.databinding.ItemListTourismBinding

class TourismAdapter : RecyclerView.Adapter<TourismAdapter.ListViewHolder>() {
    private var listData = ArrayList<TourismEntity>()
    var onItemClick: ((TourismEntity) -> Unit)? = null
    fun setData(newListData: List<TourismEntity>?){
        if(newListData == null)return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemListTourismBinding.bind(itemView)
        fun bind(data: TourismEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.address
            }
        }
        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourismAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false))
    }

    override fun onBindViewHolder(holder: TourismAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}