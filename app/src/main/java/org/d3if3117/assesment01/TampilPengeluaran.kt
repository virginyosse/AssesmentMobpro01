package org.d3if3117.assesment01

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import org.d3if3117.assesment01.data.PengeluaranDB
import org.d3if3117.assesment01.data.PengeluaranViewModel
import org.d3if3117.assesment01.data.PengeluaranViewModelFactory
import org.d3if3117.assesment01.databinding.ActivityTampilPengeluaranBinding
import org.d3if3117.assesment01.utils.PengeluaranAdapter

class TampilPengeluaran : AppCompatActivity() {
    private lateinit var binding: ActivityTampilPengeluaranBinding
    private val viewModel: PengeluaranViewModel by lazy {
        val db = PengeluaranDB.getDatabase(baseContext)
        val factory = PengeluaranViewModelFactory(db.pengeluaranDao())

        ViewModelProvider(this, factory)[PengeluaranViewModel::class.java]
    }

    private val list = arrayListOf<Pengeluaran>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilPengeluaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@TampilPengeluaran, TambahPengeluaran::class.java)
            startActivity(intent)
        }

//        val ket = intent.getStringExtra("ket")
//        binding.tvKet.text = ket
//
//        val jmlUang = intent.getStringExtra("jmlUang")
//        binding.tvTotal.text = jmlUang


        val list = arrayListOf<Pengeluaran>()
//
//        if (intent.hasExtra("coba")) {
//            data = intent.getParcelableExtra("coba")!!
//            list.add(data)
//        }

        viewModel.getAllPengeluaran().observe(this) {
            if (it == null) return@observe

            for (item in it) {
                list.add(
                    Pengeluaran(
                        keterangan = item.keterangan,
                        tanggal = item.tanggal,
                        jumlah = item.jumlah
                    )
                )
            }

            with(binding.rvListData) {
                layoutManager = LinearLayoutManager(this@TampilPengeluaran)
                adapter = PengeluaranAdapter(list)
                setHasFixedSize(true)
            }
        }
//
        Log.wtf("coba", "$list")

        binding.btnHapus.setOnClickListener { viewModel.deleteAllPengeluaran() }
//
//
//        //RECEIVE DATA
////        val keterangan = i.extras!!.getString("ket")
////        val tanggal = i.extras!!.getString("tgl")
////        val jumlah = i.extras!!.getInt("jum")
//
//        val myArrayList = ArrayList<Pengeluaran>()
//
//        // Adding data items to the ArrayList
//        if (myArrayList.isNotEmpty()) myArrayList.clear()
//        myArrayList.addAll(list)
//
//        // Accessing data from the ArrayList
//        for (item in myArrayList) {
//            val ket = item.keterangan
//            val tgl = item.tanggal
//            val jum = item.jumlah
//
//            println("$ket  $tgl $jum ")
//            var sum += jum
//            binding.tvTotal.text = sum
//        }
    }
}