package disiiy.khaper.cityweather.model

import com.google.gson.annotations.SerializedName
import disiiy.khaper.cityweather.model.all.City
import disiiy.khaper.cityweather.model.all.ListItem

data class ForecastResponse(

    @field:SerializedName("city")
	val city: City? = null,

    @field:SerializedName("cnt")
	val cnt: Int? = null,

    @field:SerializedName("cod")
	val cod: String? = null,

    @field:SerializedName("message")
	val message: Int? = null,

    @field:SerializedName("list")
	val list: List<ListItem?>? = null
)












