package com.example.countrytwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrytwo.model.Country
import com.example.countrytwo.services.CountryApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class FeedViewModel:ViewModel() {
    private val disposable=CompositeDisposable()
    private val countryApiService=CountryApiService()

    val countries=MutableLiveData<List<Country>>()
   val countryError=MutableLiveData<Boolean>()
  val countryLoading=MutableLiveData<Boolean>()

    fun refreshData() {
getdata()
    }

    private fun getdata() {
        disposable.addAll(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>) {
                        countries.value=t
                        countryLoading.value=false
                        countryError.value=false

                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                }))



    }


}