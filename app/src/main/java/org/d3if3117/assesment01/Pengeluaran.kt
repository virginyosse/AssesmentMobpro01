package org.d3if3117.assesment01

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pengeluaran(
    var keterangan: String,
    var tanggal: String,
    var jumlah: String
): Parcelable
