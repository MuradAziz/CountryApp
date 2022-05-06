package com.example.countrytwo.services

import com.example.countrytwo.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiService {
    private val base_Url="https://raw.githubusercontent.com/"
    private val api=Retrofit.Builder()
        .baseUrl(base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CountryApi::class.java)

    fun getData():Single<List<Country>>{
       return api.getCountries()
    }


}