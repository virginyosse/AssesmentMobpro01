package org.d3if3117.assesment01

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import org.d3if3117.assesment01.databinding.ActivityTambahPengeluaranBinding
import java.time.LocalDate
import java.util.*

class TambahPengeluaran: AppCompatActivity() {
    lateinit var binding: ActivityTambahPengeluaranBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPengeluaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpan.setOnClickListener { simpanData() }

    }

    fun simpanData(){
        val ket = binding.etKeterangan.text.toString()
        Toast.makeText(this@TambahPengeluaran, ket, Toast.LENGTH_SHORT).show()

        val datePicker = binding.datePicker
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)) { view, year, month, day ->
            val month = month + 1
            val msg = "$day/$month/$year"
            Toast.makeText(this@TambahPengeluaran, msg, Toast.LENGTH_SHORT).show()

            binding.txtTgl.text = msg
        }

        val tgl = binding.txtTgl.text.toString()
        val jum = binding.etJmlUang.text.toString()
        Toast.makeText(this@TambahPengeluaran, jum, Toast.LENGTH_SHORT).show()

        val intent = Intent(this@TambahPengeluaran, TampilPengeluaran::class.java)
        intent.putExtra("ket", ket)
        intent.putExtra("tgl", tgl)
        intent.putExtra("jum", jum)
        startActivity(intent)
    }
}