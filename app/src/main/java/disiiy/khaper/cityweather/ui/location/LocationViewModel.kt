package disiiy.khaper.cityweather.ui.location

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import disiiy.khaper.cityweather.model.DailyResponse
import disiiy.khaper.cityweather.model.ListItemd
import disiiy.khaper.cityweather.network.RetrofitConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class LocationViewModel : ViewModel() {

    private val apiClient = RetrofitConfig()
    private val disposable = CompositeDisposable()

    val locationDailyLiveData = MutableLiveData<List<ListItemd>>()
    var locationDailyLiveDataList : List<ListItemd> = ArrayList()
    val locationDailyLoading = MutableLiveData<Boolean>()

    fun GetLocationDailyFromGps(latitude : String, longitude : String, cnt : String, units : String){
        locationDailyLoading.value = true
        disposable.add(apiClient.getCityDailyWeatherFromGPS(latitude, longitude, cnt, units).subscribeOn(
            Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<DailyResponse>(){
                override fun onSuccess(t: DailyResponse) {
                    var locationDailyResponse = t
                    locationDailyLiveDataList = locationDailyResponse.list as List<ListItemd>
                    locationDailyLiveData.value = locationDailyLiveDataList
                    locationDailyLoading.value = false
                    Log.i("Daily Data Process", "Failed")
                }

                override fun onError(e: Throwable?) {
                    Log.i("Daily Data", "Failed")
                }

            }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}