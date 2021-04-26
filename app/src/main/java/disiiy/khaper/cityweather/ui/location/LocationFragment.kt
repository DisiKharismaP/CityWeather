package disiiy.khaper.cityweather.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import disiiy.khaper.cityweather.R
import disiiy.khaper.cityweather.databinding.FragmentLocationBinding
import im.delight.android.location.SimpleLocation

class LocationFragment : Fragment() {

    private val REQUST_CODE = 1
    private lateinit var locationViewModel: LocationViewModel
    private lateinit var locationDatabinding: FragmentLocationBinding

    var location : SimpleLocation? = null
    var latitude : String? = null
    var longitude : String? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       locationDatabinding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false)
        return locationDatabinding.root
    }
}