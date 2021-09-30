package com.skreep.coin.model

import com.google.gson.annotations.SerializedName

data class CoinModel(

    @SerializedName("name")
    var name: String,

    @SerializedName("symbol")
    var symbol: String,

    @SerializedName("rank")
    var rank: String

    )

