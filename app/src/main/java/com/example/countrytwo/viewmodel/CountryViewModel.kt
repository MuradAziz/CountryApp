package com.example.countrytwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrytwo.model.Country

class CountryViewModel:ViewModel() {

    val countries=MutableLiveData<Country>()

    fun getData(){
        val country = Country("Azerbaijan", "Baku", "Asia", "azn", "www.ss.com", "Azeri")

        countries.value=country
    }
}