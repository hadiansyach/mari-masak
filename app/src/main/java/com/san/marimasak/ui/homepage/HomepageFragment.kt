package com.san.marimasak.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.san.marimasak.R
import com.san.marimasak.databinding.FragmentHomepageBinding
import com.san.marimasak.models.Resep

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var rvResep: RecyclerView
    private var listResep = ArrayList<Resep>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(layoutInflater)

        rvResep = binding.rvResep
        rvResep.setHasFixedSize(true)

        listResep = getListResep()
        showRecyclerList()

        Log.d("onc", "onCreateView: view muncul")
        return binding.root
    }


    private fun getListResep(): ArrayList<Resep> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBahan = resources.getStringArray(R.array.data_bahan)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listResep = ArrayList<Resep>()
        for (position in dataName.indices) {
            val resep = Resep(
                dataName[position],
                dataBahan[position],
                dataPhoto.getResourceId(position, -1)
            )
            listResep.add(resep)
        }
        dataPhoto.recycle()

        Log.d("data keluar", "getListResep: $listResep")
        return listResep
    }

    private fun showRecyclerList() {
        rvResep.layoutManager = LinearLayoutManager(requireContext())
        val listResepAdapter = HomepageAdapter(listResep)
        rvResep.adapter = listResepAdapter
    }
}