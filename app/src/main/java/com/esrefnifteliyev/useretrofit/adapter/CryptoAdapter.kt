package com.esrefnifteliyev.useretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esrefnifteliyev.useretrofit.databinding.RecyclerRowBinding
import com.esrefnifteliyev.useretrofit.model.CryptoModel

class CryptoAdapter(private val list: ArrayList<CryptoModel>,private val listener : Listener) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors: Array<String> = arrayOf("#7b12f0","#d6ec19","#ea1174","#11ea35","#11eabf","#eaa511","#11c9ea","#4375ea")

    class CryptoViewHolder(val binding : RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
          fun bind(cryptoModel: CryptoModel, colors: Array<String>,listener: Listener,position: Int){
              binding.textName.text = cryptoModel.name
              binding.textCapital.text = cryptoModel.capital
              itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
              itemView.setOnClickListener {
                  listener.onItemClick(cryptoModel)
              }
          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
         val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
          holder.bind(list[position],colors,listener,position)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}
