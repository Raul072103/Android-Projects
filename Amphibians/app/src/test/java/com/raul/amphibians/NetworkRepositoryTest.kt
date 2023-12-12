package com.raul.amphibians

import com.raul.amphibians.Fake.FakeAmphibiansApiService
import com.raul.amphibians.Fake.FakeDataSource
import com.raul.amphibians.data.NetworkAmphibiansInfoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals

class NetworkRepositoryTest {

    @Test
    fun networkRepository_getAmphibiansList() =
        runTest {
            val repository = NetworkAmphibiansInfoRepository(
                amphibiansApiService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.amphibiansList, repository.getAmphibiansList())
        }

}