package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlinx.coroutines.test.runTest

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsRepository_getMarsPhotos_verifyPhotos() = runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }

}