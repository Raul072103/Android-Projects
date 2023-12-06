package com.raul.amphibians.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.raul.amphibians.network.AmphibiansApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val amphibiansInfoRepository: AmphibiansInfoRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansInfoRepository: AmphibiansInfoRepository by lazy {
        NetworkAmphibiansInfoRepository(retrofitService)
    }
}