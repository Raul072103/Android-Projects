package com.raul.amphibians.screens

import com.raul.amphibians.model.AmphibiansInfo

sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<AmphibiansInfo>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}