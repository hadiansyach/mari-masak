package com.san.marimasak.ui.homepage

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.san.marimasak.DetailResepActivity
import com.san.marimasak.databinding.ItemRowResepBinding
import com.san.marimasak.models.Resep

class HomepageAdapter(private val listResep: ArrayList<Resep>) :
    RecyclerView.Adapter<HomepageAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRowResepBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resep: Resep) {
            binding.apply {
                imgItemFoto.setImageResource(resep.foto)
                tvItemName.text = resep.namaMakanan
                tvItemBahan.text = resep.bahan
            }
            binding.root.setOnClickListener {
                val intent = Intent(itemView.context, DetailResepActivity::class.java)
                intent.putExtra(DetailResepActivity.EXTRA_MASAKAN, resep)
                itemView.context.startActivity(intent)
                Log.d("data bisa dipence", "bind: ${resep.namaMakanan}")
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