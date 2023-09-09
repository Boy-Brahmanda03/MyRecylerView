package com.example.myrecylervie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrecylervie.databinding.ItemRowHeroBinding

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>,
    private val listener: (Hero) -> Unit
): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
//    private lateinit var onItemClickCallBack: OnItemClickCallback
//
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
//        this.onItemClickCallBack = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: Hero)
//    }

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
//        holder.imgPhoto.setImageResource(photo)
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener{
//            onItemClickCallBack.onItemClicked(listHero[holder.adapterPosition])
            listener(listHero[position])
        }
    }

}