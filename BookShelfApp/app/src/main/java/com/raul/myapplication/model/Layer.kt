package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Layer(
    val layerId: String,
    val volumeAnnotationsVersion: String
)
