package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Authors(
    val title: String,
    val subtitle: String? = null,
    val authors: List<String>,
    val publisher: String? = null,
    val publishedDate: String,
    val description: String? = null,
    val industryIdentifiers: List<IndustryIdentifier>,
    val readingModes: ReadingMode,
    val pageCount: Int,
    val printType: String,
    val categories: List<String>,
    val maturityRating: String,
    val allowAnonLogging: Boolean,
    val contentVersion: String,
    val panelizationSummary: PenalizationSummary,
    val imageLinks: ImageLinksBookshelf,
    val language: String,
    val previewLink: String,
    val infoLink: String,
    val canonicalVolumeLink: String,
)
