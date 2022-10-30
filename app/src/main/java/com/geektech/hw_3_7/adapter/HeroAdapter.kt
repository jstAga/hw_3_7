package com.geektech.hw_3_7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.hw_3_7.databinding.HeroItemBinding
import com.geektech.hw_3_7.model.Hero

class HeroAdapter(private val heroList: List<Hero>, val onItemClick:(position:Int) -> Unit):
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(HeroItemBinding.inflate(LayoutInflater.
        from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(heroList[position])
    }

    override fun getItemCount() = heroList.size

    inner class HeroViewHolder(private val binding: HeroItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(hero:Hero){

            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }

            binding.tvName.text = hero.name
            binding.tvStatus.text = hero.status
            Glide.with(binding.ivAvatar).load(hero.image).into(binding.ivAvatar)
        }
    }
}