package com.example.weatherrepository.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherrepository.model.WeatherResponse
import com.example.weatherrepository.retrofit.APIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherFragmentViewModel @Inject constructor(
        private val apiService: APIService
) : ViewModel(
) {
    var weatherValue = MutableLiveData<String>("Fetching")
    var weatherValueSingle = MutableLiveData<String>("Fetching")
    fun fetchWeather() {
        apiService.fetchWeatherReport().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        object : Observer<WeatherResponse> {
                            override fun onSubscribe(d: Disposable?) {
                                print(d.toString())
                            }

                            override fun onNext(t: WeatherResponse?) {
                                weatherValue.postValue("The temperature at Coimbatore is ${t!!.current.feelslike_c.toString()}")
                            }

                            override fun onError(e: Throwable?) {
                                print(e?.localizedMessage)
                            }

                            override fun onComplete() {
                                print("COmpleted")
                            }


                        }
                )
    }

    fun fetchWeatherSingle() {


        apiService.fetchWeatherReportSingle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : SingleObserver<WeatherResponse> {
                    override fun onSubscribe(d: Disposable?) {

                        Log.d("d", d.toString())
                    }

                    override fun onSuccess(t: WeatherResponse?) {
                        weatherValueSingle.postValue("The temperature at Delhi is ${t!!.current.feelslike_c}")
                    }

                    override fun onError(e: Throwable?) {
                        Log.d("error", e?.localizedMessage.toString())
                    }

                })
    }
}