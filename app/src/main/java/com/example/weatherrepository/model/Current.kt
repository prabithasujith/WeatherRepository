package com.example.weatherrepository.model

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Current (

	val last_updated_epoch : Int,
	val last_updated : String,
	val temp_c : Int,
	val temp_f : Double,
	val is_day : Int,
	val condition : Condition,
	val wind_mph : Int,
	val wind_kph : Int,
	val wind_degree : Int,
	val wind_dir : String,
	val pressure_mb : Int,
	val pressure_in : Double,
	val precip_mm : Double,
	val precip_in : Int,
	val humidity : Int,
	val cloud : Int,
	val feelslike_c : Double,
	val feelslike_f : Double,
	val vis_km : Int,
	val vis_miles : Int,
	val uv : Int,
	val gust_mph : Int,
	val gust_kph : Double
)