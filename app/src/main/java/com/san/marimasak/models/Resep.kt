package com.san.marimasak.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resep(
    val namaMakanan: String?,
    val bahan: String?,
    val foto: Int?,
    val bumbuHalus: String?,
    val caraMasak: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    )

    companion object : Parceler<Resep> {

        override fun Resep.write(parcel: Parcel, flags: Int) {
            parcel.writeString(namaMakanan)
            parcel.writeString(bahan)
            parcel.writeValue(foto)
            parcel.writeString(bumbuHalus)
            parcel.writeString(caraMasak)
        }

        override fun create(parcel: Parcel): Resep {
            return Resep(parcel)
        }
    }
}
