package disiiy.khaper.cityweather.model.all

import com.google.gson.annotations.SerializedName

data class ListItem(

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("pop")
    val pop: Double? = null,

    @field:SerializedName("rain")
    val rain: Rain? = null,

    @field:SerializedName("visibility")
    val visibility: Int? = null,

    @field:SerializedName("dt_txt")
    val dtTxt: String? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @field:SerializedName("main")
    val main: Main? = null,

    @field:SerializedName("clouds")
    val clouds: Cloud? = null,

    @field:SerializedName("sys")
    val sys: Sys? = null,

    @field:SerializedName("wind")
    val wind: Wind? = null
)