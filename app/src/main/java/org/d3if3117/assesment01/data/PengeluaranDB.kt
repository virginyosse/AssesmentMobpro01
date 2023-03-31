package org.d3if3117.assesment01.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3117.assesment01.Pengeluaran

@Database(entities = [Pengeluaran::class], version = 1, exportSchema = false)
abstract class PengeluaranDB : RoomDatabase() {
    abstract fun pengeluaranDao(): PengeluaranDao

    companion object {
        @Volatile
        private var instance: PengeluaranDB? = null

        fun getDatabase(context: Context): PengeluaranDB {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, PengeluaranDB::class.java, "pengeluaran.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }

        }
    }


}