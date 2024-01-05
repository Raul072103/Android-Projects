package com.raul.myapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoBook(
    val title: String,
    val subtitle: String? = null,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String? = null,
    val industryIdentifiers: List<IndustryIdentifier>,
    val readingModes: ReadingMode,
    val pageCount: Int,
    val printedPageCount: Int,
    val printType: String,
    val categories: List<String>? = null,
    val maturityRating: String,
    val allowAnonLogging: Boolean,
    val contentVersion: String,
    val panelizationSummary: PenalizationSummary,
    val imageLinks: ImageLinks,
    val language: String,
    val previewLink: String,
    val infoLink: String,
    val canonicalVolumeLink: String
)
