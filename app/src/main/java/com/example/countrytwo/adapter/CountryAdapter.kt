package com.example.countrytwo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countrytwo.R
import com.example.countrytwo.model.Country
import com.example.countrytwo.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryView>() {
    class CountryView ( val view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryView {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_country, parent, false)
        return CountryView(view)

    }

    override fun onBindViewHolder(holder: CountryView, position: Int) {
        holder.view.name.text=countryList[position].countryname
        holder.view.regionName.text=countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList:List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}