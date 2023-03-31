package org.d3if3117.assesment01.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.d3if3117.assesment01.Pengeluaran

@Dao
interface PengeluaranDao {
    @Query("SELECT * FROM pengeluaran")
    fun getAllPengeluaran(): LiveData<List<Pengeluaran>>

    @Insert
    suspend fun insertPengeluaran(pengeluaran: Pengeluaran)

    @Query("TRUNCATE pengeluaran")
    suspend fun deleteAllPengeluaran()
}