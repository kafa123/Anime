package com.example.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anime.databinding.AnimekBinding

typealias OnClickAnimek =((DataItem)->Unit)
class AnimekAdapter(private var AnimekList:ArrayList<DataItem>, private val onClickAnimek:OnClickAnimek): RecyclerView.Adapter<AnimekAdapter.AnimekViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimekAdapter.AnimekViewHolder {
        val binding=AnimekBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnimekViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimekAdapter.AnimekViewHolder, position: Int) {
        holder.bind(AnimekList[position])
    }

    override fun getItemCount(): Int {
        return AnimekList.size
    }

    inner class AnimekViewHolder(private val binding:AnimekBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:DataItem){
            with(binding){
                data.entry?.get(0)?.let {
                    titleAnimek.text = it.title
                    // Assuming you want to load the JPG image
                    val imageUrl = it.images?.jpg?.imageUrl
                    imageUrl?.let {
                        Glide.with(itemView.context).load(it).centerCrop().into(animekImake)
                    }
                }
                contentAnimek.text=data.content
                itemView.setOnClickListener {
                    onClickAnimek(data)
                }
            }
        }
    }

}