package com.skreep.coin.Interface

import com.skreep.coin.model.CoinModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("coins")
    fun getCoinList(): Call<List<CoinModel>>
}