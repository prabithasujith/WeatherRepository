package com.example.weatherrepository.di

import com.example.weatherrepository.MainActivity
import com.example.weatherrepository.views.WeatherFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: WeatherFragment)
}