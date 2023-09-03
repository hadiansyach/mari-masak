package com.san.marimasak

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.san.marimasak.databinding.ActivityDetailResepBinding
import com.san.marimasak.models.Resep

class DetailResepActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResepBinding

    companion object {
        const val EXTRA_MASAKAN = "extra_masakan"
        const val EXTRA_BAHAN = "extra_bahan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvNamaMasakanReceived = binding.tvNamaMasakan
        val ivFotoMasakan = binding.ivMasakan
        val tvBahanReceived = binding.tvBahanMasakan
        val tvBumbuHalusReceived = binding.tvBumbuHalus
        val tvCaraMasakReceived = binding.tvCaraMasak

        val resep = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_MASAKAN, Resep::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Resep>(EXTRA_MASAKAN)
        }

        if (resep != null) {
            tvNamaMasakanReceived.text = resep.namaMakanan
            tvBahanReceived.text = resep.bahan
            tvBumbuHalusReceived.text = resep.bumbuHalus
            tvCaraMasakReceived.text = resep.caraMasak
            ivFotoMasakan.setImageResource(resep.foto)
        }

    }
}