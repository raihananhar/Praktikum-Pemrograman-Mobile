package com.example.RaihanAnhar203040113.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PendaftaranAwal(
    @PrimaryKey val id: String,
    val idmember: String,
    val nama: String,
    val tempatLahir: String,
    val tglLahir: String,
    val alamat: String,
    val noHp: String
)
