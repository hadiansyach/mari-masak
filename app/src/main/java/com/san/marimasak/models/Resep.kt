package com.san.marimasak.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resep(
    val namaMakanan: String,
    val bahan: String,
    val foto: Int
) : Parcelable
