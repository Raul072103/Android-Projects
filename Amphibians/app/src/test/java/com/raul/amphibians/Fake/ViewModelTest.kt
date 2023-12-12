package com.raul.amphibians.Fake

import com.raul.amphibians.rules.TestDispatcherRule
import com.raul.amphibians.screens.AmphibiansUiState
import com.raul.amphibians.screens.AmphibiansViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class ViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibiansList_verifyAmphibiansStateSuccess() =
        runTest {
            val viewModelTest = AmphibiansViewModel(
                amphibiansInfoRepository = FakeNetworkRepository()
            )
            assertEquals(
                viewModelTest.amphibiansUiState,
                AmphibiansUiState.Success(FakeDataSource.amphibiansList))
        }

}