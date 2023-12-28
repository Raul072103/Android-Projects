package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchInfo(
    val textSnippet: String
)
