package com.raul.myapplication

import com.raul.myapplication.data.NetworkBookshelfAppRepository
import com.raul.myapplication.fake.FakeBookshelfApiService
import com.raul.myapplication.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBookshelfRepositoryTest {

    @Test
    fun networkBookshelfRepository_getAllBooks_verifyBookList() =
        runTest {
            val repository = NetworkBookshelfAppRepository(
                bookshelfApiService = FakeBookshelfApiService()
            )
            assertEquals(FakeDataSource.volumeInfo, repository.getAllBooks())
        }


    @Test
    fun networkBookshelfRepository_getBookInfo_verifyBookInfo() =
        runTest {
            val repository = NetworkBookshelfAppRepository(
                bookshelfApiService = FakeBookshelfApiService()
            )
            assertEquals(FakeDataSource.bookInfo, repository.getBookUrl(id = "J9G50L3c14QC"))
        }

}