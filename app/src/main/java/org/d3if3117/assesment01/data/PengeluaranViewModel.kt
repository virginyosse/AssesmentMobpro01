package org.d3if3117.assesment01.data

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3117.assesment01.Pengeluaran

@Suppress("UNCHECKED_CAST")
class PengeluaranViewModelFactory(private val pengeluaranDao: PengeluaranDao) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PengeluaranViewModel::class.java)) return PengeluaranViewModel(
            pengeluaranDao
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class PengeluaranViewModel(val pengeluaranDao: PengeluaranDao) : ViewModel() {
    private val pengeluaran = MutableLiveData<Pengeluaran?>()

    fun getAllPengeluaran(): LiveData<List<Pengeluaran>> = pengeluaranDao.getAllPengeluaran()

    fun deleteAllPengeluaran() = pengeluaranDao.deleteAllPengeluaran()

    fun insertPengeluaran(keterangan: String, tanggal: String, jumlah: Int) {
        val data = Pengeluaran(
            keterangan = keterangan,
            tanggal = tanggal,
            jumlah = jumlah
        )

        pengeluaran.value = data

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                pengeluaranDao.insertPengeluaran(data)
            }
        }
    }
}