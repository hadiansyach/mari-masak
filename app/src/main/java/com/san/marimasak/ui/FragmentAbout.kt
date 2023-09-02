package com.san.marimasak.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.san.marimasak.databinding.FragmentAboutBinding

class FragmentAbout : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAboutBinding.inflate(layoutInflater)
    }
}