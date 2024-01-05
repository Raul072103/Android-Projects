package com.raul.myapplication.network

import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BookshelfApiService {

    @GET("?q=jazz+history")
    suspend fun getAllBooks(): VolumeInfo

    @GET("{id}")
    suspend fun getBookInfo(@Path("id") id: String): BookInfo
}