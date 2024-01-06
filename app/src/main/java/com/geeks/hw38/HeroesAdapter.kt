package com.geeks.hw38

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geeks.hw38.databinding.ItemHeroBinding

class HeroesAdapter(
    private val list: ArrayList<Hero>,
    private val onItemClick: (hero: Hero) -> Unit
) : Adapter<HeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            ItemHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick(list[position])
        }
    }
}

class HeroViewHolder(private val binding: ItemHeroBinding) : ViewHolder(binding.root) {
    fun onBind(hero: Hero) {
        binding.tvItemHeroName.text = hero.name
        binding.ivItemHeroImage.setImageByURL(hero.imageURL)
        if (hero.status) binding.tvItemHeroStatus.text =
            binding.root.resources.getString(R.string.status_alive)
        else binding.tvItemHeroStatus.text = binding.root.resources.getString(R.string.status_dead)
    }
}