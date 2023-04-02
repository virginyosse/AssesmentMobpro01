package org.d3if3117.assesment01.data

import kotlinx.coroutines.flow.Flow
import org.d3if3117.assesment01.Pengeluaran

interface PengeluaranRepo {
    fun getAllPengeluaran(): Flow<List<Pengeluaran>>
    suspend fun insertPengeluaran(pengeluaran: Pengeluaran)
    suspend fun deleteAllPengeluaran()
}