package com.emreaktrk.sahibinden.feature.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.sahibinden.databinding.ItemWordBinding

class WordAdapter(private val list: List<WordModel>) : RecyclerView.Adapter<WordAdapter.Holder>() {

    class Holder(private val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: WordModel) {
            binding.model = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWordBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int = list.size
}