package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifier(
    val type: String,
    val identifier: String
)
