package disiiy.khaper.cityweather.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import disiiy.khaper.cityweather.model.WeatherResponse
import disiiy.khaper.cityweather.network.RetrofitConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(application :Application) : AndroidViewModel(application) {
    private val apiClient = RetrofitConfig()
    private val disposable = CompositeDisposable()

    val locationData = MutableLiveData<WeatherResponse>()
    val locationLoading = MutableLiveData<Boolean>()

    fun getWeatherDataWithGPS(latitude :String, longitude :String, units :String){
        locationLoading.value = true
        disposable.add(
            apiClient.getDataFromGPS(latitude, longitude, units)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<WeatherResponse>(){
                override fun onSuccess(t: WeatherResponse) {
                    locationData.value = t
                    locationLoading.value = false
                    Log.i("Success", "Data on Showed")
                }

                override fun onError(e: Throwable) {
                    Log.i("Failed", "Data not Showed" + e.message + "" + e.printStackTrace())
                }

            })
        )
    }

    override fun onCleared(){
        super.onCleared()
        disposable.clear()
    }
}