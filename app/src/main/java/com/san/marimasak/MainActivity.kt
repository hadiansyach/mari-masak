package com.san.marimasak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.san.marimasak.databinding.ActivityMainBinding
import com.san.marimasak.models.Resep

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvResep: RecyclerView
    private var listResep = ArrayList<Resep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvResep = findViewById(R.id.rv_resep)
        rvResep.setHasFixedSize(true)

        listResep.addAll(getListResep())
        showRecyclerList()
    }

    private fun getListResep(): ArrayList<Resep> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBahan = resources.getStringArray(R.array.data_bahan)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listResep = ArrayList<Resep>()
        for (position in dataName.indices) {
            val resep = Resep(dataName[position], dataBahan[position], dataPhoto.getResourceId(position, -1))
            listResep.add(resep)
        }
        dataPhoto.recycle()
        return listResep
    }
    private fun showRecyclerList() {
        rvResep.layoutManager = LinearLayoutManager(this)
        val listResepAdapter = ListResepAdapter(listResep)
        rvResep.adapter = listResepAdapter
    }
}