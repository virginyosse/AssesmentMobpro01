package org.d3if3117.assesment01

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.d3if3117.assesment01.databinding.ActivityTampilPengeluaranBinding

class TampilPengeluaran : AppCompatActivity() {
    private lateinit var binding: ActivityTampilPengeluaranBinding
    private val list = arrayListOf<Pengeluaran>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilPengeluaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@TampilPengeluaran, TambahPengeluaran::class.java)
            startActivity(intent)
        }

        //GET INTENT
//        val i = this.intent
        val data: Pengeluaran

        if (intent.hasExtra("coba")) {
            data = intent.getParcelableExtra("coba")!!
            list.add(data)
        }

        Log.wtf("coba", "$list")


        //RECEIVE DATA
//        val keterangan = i.extras!!.getString("ket")
//        val tanggal = i.extras!!.getString("tgl")
//        val jumlah = i.extras!!.getInt("jum")

        val myArrayList = ArrayList<Pengeluaran>()

        // Adding data items to the ArrayList
        if (myArrayList.isNotEmpty()) myArrayList.clear()
        myArrayList.addAll(list)

        // Accessing data from the ArrayList
        for (item in myArrayList) {
            val ket = item.keterangan
            val tgl = item.tanggal
            val jum = item.jumlah

            println("$ket  $tgl $jum ")
            var sum += jum
            binding.tvTotal.text = sum
        }
    }
}