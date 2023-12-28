package com.raul.myapplication.data

import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo
import com.raul.myapplication.network.BookshelfApiService

class NetworkBookshelfAppRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfAppRepository {

    override suspend fun getAllBooks(): VolumeInfo {
        return bookshelfApiService.getAllBooks()
    }

    override suspend fun getBookUrl(id: String): BookInfo {
        val bookInfo = bookshelfApiService.getBookInfo(id = id)
        return bookInfo
    }
}