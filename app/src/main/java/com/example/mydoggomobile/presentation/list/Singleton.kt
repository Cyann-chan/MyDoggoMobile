package com.example.mydoggomobile.presentation.list

import com.example.mydoggomobile.presentation.list.DoggoApplication.Companion.context
import com.example.mydoggomobile.presentation.list.api.DoggoApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singleton {
    companion object {
        var cache: Cache = Cache(File(context?.cacheDir, "response"), 10 * 1024 * 1024) //10 MiB

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val doggoApi: DoggoApi = Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
            .build()
            .create(DoggoApi::class.java)}
}