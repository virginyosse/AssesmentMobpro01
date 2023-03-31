package org.d3if3117.assesment01.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import org.d3if3117.assesment01.Pengeluaran
import org.d3if3117.assesment01.databinding.ItemListBinding

class PengeluaranAdapter(private val list:ArrayList<Pengeluaran>) :
    RecyclerView.Adapter<PengeluaranAdapter.PengeluaranViewHolder>() {

    class PengeluaranViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pengeluaran: Pengeluaran){
            with(binding){
                ket.text = pengeluaran.keterangan
                date.text = pengeluaran.tanggal
                jum.text = pengeluaran.jumlah.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PengeluaranViewHolder(
        ItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: PengeluaranViewHolder, position: Int) = with(holder) {
        bind(list[position])
    }

    override fun getItemCount() = list.size

}