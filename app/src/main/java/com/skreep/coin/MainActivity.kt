package com.skreep.coin

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skreep.coin.Interface.RetrofitServices
import com.skreep.coin.adapter.MainAdapter
import com.skreep.coin.common.Common
import com.skreep.coin.databinding.ActivityMainBinding
import com.skreep.coin.model.CoinModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MainAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mService = Common.retrofitService
        binding.rv.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = layoutManager

        getAllMovieList()

    }


    private fun getAllMovieList() {
        mService.getCoinList().enqueue(object : Callback<List<CoinModel>> {
            override fun onResponse(
                call: Call<List<CoinModel>>,
                response: Response<List<CoinModel>>
            ) {
                adapter = MainAdapter(baseContext, response.body() as MutableList<CoinModel>)
                adapter.notifyDataSetChanged()
                binding.rv.adapter = adapter
            }

            override fun onFailure(call: Call<List<CoinModel>>, t: Throwable) {

            }


        })
}
}