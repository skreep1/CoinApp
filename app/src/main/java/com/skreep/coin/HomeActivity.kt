package com.skreep.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.skreep.coin.Interface.RetrofitServices
import com.skreep.coin.adapter.HomeAdapter
import com.skreep.coin.common.Common
import com.skreep.coin.databinding.ActivityMainBinding
import com.skreep.coin.model.CoinModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: HomeAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mService = Common.retrofitService
        binding.rv.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = layoutManager

        getCoinList()


    }


    private fun getCoinList() {
        mService.getCoinList().enqueue(object : Callback<List<CoinModel>> {
            override fun onResponse(
                call: Call<List<CoinModel>>,
                response: Response<List<CoinModel>>
            ) {
                adapter = HomeAdapter(baseContext, response.body() as MutableList<CoinModel>)
                adapter.notifyDataSetChanged()
                binding.rv.adapter = adapter
            }

            override fun onFailure(call: Call<List<CoinModel>>, t: Throwable) {

            }


        })
    }

}