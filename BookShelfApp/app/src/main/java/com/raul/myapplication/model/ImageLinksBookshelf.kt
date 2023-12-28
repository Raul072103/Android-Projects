package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksBookshelf(
    val smallThumbnail: String,
    val thumbnail: String
)
