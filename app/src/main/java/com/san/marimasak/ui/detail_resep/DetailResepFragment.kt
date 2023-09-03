package com.san.marimasak.ui.detail_resep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.san.marimasak.databinding.FragmentDetailResepBinding

class DetailResepFragment : Fragment() {
    private lateinit var binding: FragmentDetailResepBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailResepBinding.inflate(layoutInflater)
        return binding.root
    }


}