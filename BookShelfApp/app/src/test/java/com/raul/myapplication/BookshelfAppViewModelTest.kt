package com.raul.myapplication

import com.raul.myapplication.fake.FakeDataSource
import com.raul.myapplication.fake.FakeNetworkBookshelfAppRepository
import com.raul.myapplication.rules.TestDispatcherRule
import com.raul.myapplication.ui.screens.BookshelfUiSate
import com.raul.myapplication.ui.screens.BookshelfViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BookshelfAppViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookshelfViewModel_getBookInfo_verifyBookshelfUiStateSuccess() =
        runTest {
            val bookshelfViewModel = BookshelfViewModel(
                bookshelfAppRepository = FakeNetworkBookshelfAppRepository()
            )
            assertEquals(
                BookshelfUiSate.Success(FakeDataSource.bookUrls),
                bookshelfViewModel.bookshelfUiSate
            )
        }
}