package com.example.RaihanAnhar203040113.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.RaihanAnhar203040113.model.PendaftaranAwal

@Database(entities = [PendaftaranAwal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pendaftaranAwalDao(): PendaftaranAwalDao
}