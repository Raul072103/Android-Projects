package com.raul.myapplication.data

import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo

interface BookshelfAppRepository {
    suspend fun getAllBooks(): VolumeInfo

    suspend fun getBookUrl(id: String): BookInfo
}

