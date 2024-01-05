package com.raul.myapplication.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.raul.myapplication.network.BookshelfApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class DefaultAppContainer : AppContainer {

    private val baseUrl: String = "https://www.googleapis.com/books/v1/volumes/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }
    override val bookshelfAppRepository: BookshelfAppRepository by lazy {
        NetworkBookshelfAppRepository(retrofitService)
    }

}