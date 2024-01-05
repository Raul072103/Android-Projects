package com.raul.myapplication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookInfo (
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfoBook,
    val layerInfo: LayerInfo? = null,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo
)
