package com.raul.amphibians.data

import com.raul.amphibians.model.AmphibiansInfo
import com.raul.amphibians.network.AmphibiansApiService

class NetworkAmphibiansInfoRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansInfoRepository {
    override suspend fun getAmphibiansList(): List<AmphibiansInfo> = amphibiansApiService.getAmphibiansList()
}