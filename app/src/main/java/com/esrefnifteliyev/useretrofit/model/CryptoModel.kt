package com.esrefnifteliyev.useretrofit.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String
)
