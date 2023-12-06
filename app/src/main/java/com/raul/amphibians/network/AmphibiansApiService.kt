package com.raul.amphibians.network

import com.raul.amphibians.model.AmphibiansInfo
import retrofit2.http.GET

interface AmphibiansApiService {

    @GET("amphibians")
    suspend fun getAmphibiansList(): List<AmphibiansInfo>

}