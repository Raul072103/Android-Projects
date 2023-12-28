package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class ReadingMode(
    val text: Boolean,
    val image: Boolean
)
