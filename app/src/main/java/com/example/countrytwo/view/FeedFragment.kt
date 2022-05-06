package com.example.countrytwo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrytwo.R
import com.example.countrytwo.adapter.CountryAdapter
import com.example.countrytwo.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import java.util.ArrayList


class FeedFragment : Fragment() {
    lateinit var viewModel:FeedViewModel
    var countryAdapter=CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel=ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        countryList.layoutManager=LinearLayoutManager(context)
        countryList.adapter=countryAdapter
        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries->
            countries?.let {
                countryList.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }



        })
        viewModel.countryError.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if (it) {
                    CountryError.visibility = View.VISIBLE
                } else {
                    CountryError.visibility = View.GONE
                }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { Load->
            Load?.let {
                if(it){
                    countryLoading.visibility=View.VISIBLE
                    countryList.visibility=View.GONE
                    CountryError.visibility=View.GONE
                }else{
                    countryLoading.visibility=View.GONE
                }

            }
        })
    }

}