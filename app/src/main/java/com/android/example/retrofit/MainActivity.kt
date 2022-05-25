package com.android.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


interface PunkService {
    @GET("v2/beers")
    fun listRepos(@Path("user") user: String?): List<Beers>
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/v2/")
        .build()

    var service: PunkService = retrofit.create(PunkService::class.java)
}