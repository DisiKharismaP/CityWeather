package disiiy.khaper.cityweather.model

import com.google.gson.annotations.SerializedName

data class DailyResponse(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("cod")
	val cod: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("list")
	val list: List<ListItemd?>? = null
)


data class Coordd(

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)


data class Maind(

	@field:SerializedName("temp")
	val temp: Double? = null,

	@field:SerializedName("temp_min")
	val tempMin: Double? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("pressure")
	val pressure: Int? = null,

	@field:SerializedName("feels_like")
	val feelsLike: Double? = null,

	@field:SerializedName("temp_max")
	val tempMax: Double? = null,

	@field:SerializedName("grnd_level")
	val grndLevel: Int? = null,

	@field:SerializedName("sea_level")
	val seaLevel: Int? = null
)


data class Windd(

	@field:SerializedName("deg")
	val deg: Int? = null,

	@field:SerializedName("speed")
	val speed: Double? = null
)


data class Sysd(

	@field:SerializedName("country")
	val country: String? = null
)


data class WeatherItemd(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("main")
	val main: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)


data class ListItemd(

	@field:SerializedName("dt")
	val dt: Int? = null,

	@field:SerializedName("rain")
	val rain: Any? = null,

	@field:SerializedName("coord")
	val coord: Coordd? = null,

	@field:SerializedName("snow")
	val snow: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("weather")
	val weather: List<WeatherItemd?>? = null,

	@field:SerializedName("main")
	val main: Maind? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("clouds")
	val clouds: Cloudsd? = null,

	@field:SerializedName("sys")
	val sys: Sysd? = null,

	@field:SerializedName("wind")
	val wind: Windd? = null
)


data class Cloudsd(

	@field:SerializedName("all")
	val all: Int? = null
)