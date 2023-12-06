package com.raul.amphibians.data

import com.raul.amphibians.model.AmphibiansInfo

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansList(): List<AmphibiansInfo>
}