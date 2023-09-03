package com.san.marimasak.models

import android.os.Parcel
import android.os.Parcelable

data class Resep(
    val namaMakanan: String?,
    val bahan: String?,
    val foto: Int,
    val bumbuHalus: String?,
    val caraMasak: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaMakanan)
        parcel.writeString(bahan)
        parcel.writeInt(foto)
        parcel.writeString(bumbuHalus)
        parcel.writeString(caraMasak)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Resep> {
        override fun createFromParcel(parcel: Parcel): Resep {
            return Resep(parcel)
        }

        override fun newArray(size: Int): Array<Resep?> {
            return arrayOfNulls(size)
        }
    }
}
