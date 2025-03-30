package com.esrefnifteliyev.useretrofit.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.esrefnifteliyev.useretrofit.R
import com.esrefnifteliyev.useretrofit.adapter.CryptoAdapter
import com.esrefnifteliyev.useretrofit.databinding.ActivityMainBinding
import com.esrefnifteliyev.useretrofit.model.CryptoModel
import com.esrefnifteliyev.useretrofit.service.CryptoApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), CryptoAdapter.Listener {
    private val BASE_URL = "https://countryapi.io/api/"
    private var cryptoList : ArrayList<CryptoModel>? = null
    private var cryptoAdapter: CryptoAdapter? = null
    private lateinit var binding: ActivityMainBinding
    private var compositeDisposable: CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val layoutManager : LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadData()

        compositeDisposable = CompositeDisposable()


    }

    fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(CryptoApi::class.java)


        compositeDisposable?.add(retrofit.getData()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(this::handleResponse))



    }

    private fun handleResponse(cryptoModel: List<CryptoModel>){
         cryptoList = ArrayList(cryptoModel)
         cryptoList?.let { list ->
             cryptoAdapter = CryptoAdapter(list,this@MainActivity)
             binding.recyclerView.adapter= cryptoAdapter
         }
    }


    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this,"Clicked : ${cryptoModel.name}",Toast.LENGTH_LONG ).show()
    }

   // 1820KgDq3GMXPPLXJr9cGYwIp5GnJNSt4onktrME

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }


}