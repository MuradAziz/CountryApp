package com.example.countrytwo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.countrytwo.R
import com.example.countrytwo.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*

class CountryFragment : Fragment() {
        lateinit var viewModel:CountryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getData()
        observeLivedata()

    }

    fun observeLivedata(){
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries->
            countries?.let {
            countryName.text=countries.countryname
                countryCapital.text=countries.capital
                countryRegion.text=countries.countryRegion
                countryLanguage.text=countries.language
                countryCurrency.text=countries.currency

            }
        })
    }
}