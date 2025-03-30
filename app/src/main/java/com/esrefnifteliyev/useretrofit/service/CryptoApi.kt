package com.esrefnifteliyev.useretrofit.service

import com.esrefnifteliyev.useretrofit.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {


    @GET("all?apikey=1820KgDq3GMXPPLXJr9cGYwIp5GnJNSt4onktrME")
    fun getData() : Observable<List<CryptoModel>>

    //fun getData() : Call<List<CryptoModel>>


}