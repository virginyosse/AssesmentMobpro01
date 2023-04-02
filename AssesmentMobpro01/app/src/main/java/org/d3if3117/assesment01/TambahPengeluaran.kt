package org.d3if3117.assesment01

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.d3if3117.assesment01.data.PengeluaranDB
import org.d3if3117.assesment01.data.PengeluaranViewModel
import org.d3if3117.assesment01.data.PengeluaranViewModelFactory
import org.d3if3117.assesment01.databinding.ActivityTambahPengeluaranBinding
import java.time.LocalDate
import java.util.*

class TambahPengeluaran : AppCompatActivity() {
    private lateinit var binding: ActivityTambahPengeluaranBinding
    private lateinit var ket: String
    private lateinit var jmlUang: String

    private val viewModel: PengeluaranViewModel by lazy {
        val db = PengeluaranDB.getDatabase(baseContext)
        val factory = PengeluaranViewModelFactory(db.pengeluaranDao())

        ViewModelProvider(this, factory)[PengeluaranViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPengeluaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpan.setOnClickListener {
            ket = binding.etKeterangan.text.toString()
            jmlUang = binding.etJmlUang.text.toString()

            viewModel.insertPengeluaran(ket, LocalDate.now().toString(), jmlUang.toInt())

            val intent = Intent(this, TampilPengeluaran::class.java)
            intent.putExtra(
                "coba",
                Pengeluaran(
                    keterangan = ket,
                    tanggal = LocalDate.now().toString(),
                    jumlah = jmlUang.toInt()
                )
            )
            startActivity(intent)
        }
    }

//    fun simpanData(){
//        val ket = binding.etKeterangan.text.toString()
//        var msg = ""
////        Toast.makeText(this@TambahPengeluaran, ket, Toast.LENGTH_SHORT).show()
//
//        val datePicker = binding.datePicker
//        val today = Calendar.getInstance()
//        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)) { view, year, month, day ->
//            val months = month + 1
//            msg = "$day/$months/$year"
////            Toast.makeText(this@TambahPengeluaran, msg, Toast.LENGTH_SHORT).show()
//
//            binding.txtTgl.text = msg
//        }
//
//        val tgl = binding.txtTgl.text.toString()
//        val jum = binding.etJmlUang.text.toString()
//
////        Toast.makeText(this@TambahPengeluaran, jum, Toast.LENGTH_SHORT).show()
////        Log.wtf("Test", "simpanData: $jum")
//
//        val pengeluaran = Pengeluaran(ket,     msg, jum)
////        Log.wtf("coba", "simpanData: $msg" )
//        val intent = Intent(this@TambahPengeluaran, TampilPengeluaran::class.java).apply {
//            putExtra("coba", pengeluaran)
//        }
////        intent.putExtra("ket", ket)
////        intent.putExtra("tgl", tgl)
////        intent.putExtra("jum", jum)
//        startActivity(intent)
//    }
}