package com.esrefnifteliyev.useretrofit.service

import com.esrefnifteliyev.useretrofit.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoApi {

    @GET("atilsamancioglu/K21-JSONDataSet/refs/heads/master/crypto.json")
    fun getData() : Observable<List<CryptoModel>>

    //fun getData() : Call<List<CryptoModel>>


}