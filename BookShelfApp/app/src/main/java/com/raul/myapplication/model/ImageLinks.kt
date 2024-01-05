package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
    val small: String? = null,
    val medium: String? = null
)
