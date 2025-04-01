package com.esrefnifteliyev.useretrofit.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("currency")
    val name: String,
    @SerializedName("price")
    val capital: String
)
