package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class LayerInfo(
    val layers: List<Layer>
)
