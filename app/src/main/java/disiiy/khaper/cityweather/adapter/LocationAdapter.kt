package disiiy.khaper.cityweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import disiiy.khaper.cityweather.R
import disiiy.khaper.cityweather.databinding.LocationItemBinding
import disiiy.khaper.cityweather.model.ListItemd

class LocationAdapter(val locationList : ArrayList<ListItemd>) :RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    class LocationViewHolder (var view : LocationItemBinding): RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<LocationItemBinding>(
            inflater, R.layout.location_item, parent, false
        )
        return LocationViewHolder(view)
    }

    override fun getItemCount(): Int = locationList.size

    fun updateCountryList(newCountryList : List<ListItemd>){
        locationList.clear()
        locationList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.view.locationWeather  = locationList[position]
//        holder.view.tvTemperature.text = locationList[position].main!!.temp!!.toInt().toString() //cara lainnya
        holder.itemView.setOnClickListener {

        }
    }

}