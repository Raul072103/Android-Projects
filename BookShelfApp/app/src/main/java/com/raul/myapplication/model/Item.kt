package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: Authors,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo
)