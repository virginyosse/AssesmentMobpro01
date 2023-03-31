package org.d3if3117.assesment01

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pengeluaran")
data class Pengeluaran(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var keterangan: String,
    var tanggal: String,
    var jumlah: Int
): Parcelable
