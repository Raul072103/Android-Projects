package com.raul.myapplication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>
)
