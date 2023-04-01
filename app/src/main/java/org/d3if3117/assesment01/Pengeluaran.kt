package org.d3if3117.assesment01

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pengeluaran")
data class Pengeluaran(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,

    @ColumnInfo("keterangan")
    var keterangan: String,

    @ColumnInfo("tnggal")
    var tanggal: String,

    @ColumnInfo("jumlah")
    var jumlah: Int
): Parcelable
