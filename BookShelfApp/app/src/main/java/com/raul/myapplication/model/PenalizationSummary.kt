package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class PenalizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)
