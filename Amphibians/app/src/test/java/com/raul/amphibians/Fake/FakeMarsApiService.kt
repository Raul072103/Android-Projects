package com.raul.amphibians.Fake

import com.raul.amphibians.model.AmphibiansInfo
import com.raul.amphibians.network.AmphibiansApiService

class FakeAmphibiansApiService : AmphibiansApiService {
    override suspend fun getAmphibiansList(): List<AmphibiansInfo> {
         return FakeDataSource.amphibiansList
    }
}