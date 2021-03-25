package com.example.weatherrepository

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.weatherrepository.di.DaggerApplicationComponent
open class MyApplication :Application() {
    val appComponent = DaggerApplicationComponent.create()

}