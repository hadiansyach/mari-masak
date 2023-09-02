package com.san.marimasak.ui.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.san.marimasak.databinding.ItemRowResepBinding
import com.san.marimasak.models.Resep

class HomepageAdapter(private val listResep: ArrayList<Resep>) : RecyclerView.Adapter<HomepageAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRowResepBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(resep: Resep) {
            binding.apply {
                imgItemFoto.setImageResource(resep.foto)
                tvItemName.text = resep.namaMakanan
                tvItemBahan.text = resep.bahan
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRowResepBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listResep.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resep = listResep[position]
        holder.bind(resep)
    }


}