package org.d3if3117.assesment01.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.d3if3117.assesment01.Pengeluaran

@Dao
interface PengeluaranDao {
    @Query("SELECT * FROM pengeluaran")
    fun getAllPengeluaran(): Flow<List<Pengeluaran>>

    @Insert
    suspend fun insertPengeluaran(pengeluaran: Pengeluaran)

//    @Query("TRUNCATE pengeluaran")
//    suspend fun deleteAllPengeluaran()

    @Query("DELETE FROM pengeluaran")
    fun deleteAllPengeluaran()
}