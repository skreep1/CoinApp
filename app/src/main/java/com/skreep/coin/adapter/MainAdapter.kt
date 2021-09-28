package com.skreep.coin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skreep.coin.databinding.ItemRowBinding
import com.skreep.coin.model.CoinModel

class MainAdapter(private val context: Context, private val coinList: MutableList<CoinModel>) :
    RecyclerView.Adapter<MainAdapter.CoinViewHolder>() {

    class CoinViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(ItemRowBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val listCoin = coinList[position]
        holder.binding.nameTv.text = listCoin.name
        holder.binding.symbolTv.text = listCoin.symbol

    }

    override fun getItemCount(): Int {
       return coinList.size
    }


}