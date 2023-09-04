package com.san.marimasak

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.san.marimasak.databinding.ActivityDetailResepBinding
import com.san.marimasak.models.Resep

class DetailResepActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResepBinding

    companion object {
        const val EXTRA_MASAKAN = "extra_masakan"
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
            intent.getParcelableExtra(EXTRA_MASAKAN)
        }

        if (resep != null) {
            tvNamaMasakanReceived.text = resep.namaMakanan
            tvBahanReceived.text = resep.bahan
            tvBumbuHalusReceived.text = resep.bumbuHalus
            tvCaraMasakReceived.text = resep.caraMasak
            ivFotoMasakan.setImageResource(resep.foto)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> {
                shareData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareData() {
        val message = getString(
            R.string.share_template,
            binding.tvNamaMasakan.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        startActivity(shareIntent)
    }

}