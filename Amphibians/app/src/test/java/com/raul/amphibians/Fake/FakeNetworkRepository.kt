package com.raul.amphibians.Fake

import com.raul.amphibians.data.AmphibiansInfoRepository
import com.raul.amphibians.model.AmphibiansInfo

class FakeNetworkRepository : AmphibiansInfoRepository{
    override suspend fun getAmphibiansList(): List<AmphibiansInfo> {
        return FakeDataSource.amphibiansList
    }
}