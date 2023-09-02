package com.san.marimasak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.san.marimasak.models.Resep

class ListResepAdapter(private val listResep: ArrayList<Resep>) :
    RecyclerView.Adapter<ListResepAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_resep, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listResep.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (namaMakanan, deskripsi, foto) = listResep[position]
        holder.imgFoto.setImageResource(foto)
        holder.tvNamaMakanan.text = namaMakanan
        holder.tvDeskripsi.text = deskripsi
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.img_item_foto)
        val tvNamaMakanan: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_item_bahan)
    }
}