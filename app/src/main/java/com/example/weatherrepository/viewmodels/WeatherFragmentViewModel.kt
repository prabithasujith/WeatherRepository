package com.example.weatherrepository.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherrepository.model.WeatherResponse
import com.example.weatherrepository.retrofit.APIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherFragmentViewModel @Inject constructor(
        private val apiService: APIService
) : ViewModel(
) {
    private var _weatherValue = MutableLiveData<String>("")
    private lateinit var disposable: Disposable
    val weatherValue: LiveData<String> = _weatherValue
    fun fetchWeather() {
        apiService.fetchWeatherReport().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        object : Observer<WeatherResponse> {
                            override fun onSubscribe(d: Disposable?) {
                                print(d.toString())
                                disposable = d!!
                            }

                            override fun onNext(t: WeatherResponse?) {
                                _weatherValue.value = ("The temperature at Coimbatore is ${t!!.current.feelslike_c.toString()}")
                            }

                            override fun onError(e: Throwable?) {
                                print(e?.localizedMessage)
                            }

                            override fun onComplete() {
                                print("Completed")
                            }


                        }
                )
    }

    fun dispose(){
        disposable.dispose()
    }

}