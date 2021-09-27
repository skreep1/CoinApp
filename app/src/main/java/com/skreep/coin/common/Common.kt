package com.skreep.coin.common

import com.skreep.coin.Interface.RetrofitServices
import com.skreep.coin.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.coinpaprika.com/v1/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}