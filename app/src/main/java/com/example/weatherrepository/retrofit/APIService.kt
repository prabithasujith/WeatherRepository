package com.example.weatherrepository.retrofit

import com.example.weatherrepository.model.WeatherResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("current.json?key=1a2028b00b8e4099844143106212503&q=Coimbatore&aqi=no")
    fun fetchWeatherReport( ):Observable<WeatherResponse>

    @GET("current.json?key=1a2028b00b8e4099844143106212503&q=Delhi&aqi=no")
    fun fetchWeatherReportSingle( ): Single<WeatherResponse>
}