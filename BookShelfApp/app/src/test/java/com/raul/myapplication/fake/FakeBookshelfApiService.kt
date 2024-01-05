package com.raul.myapplication.fake

import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo
import com.raul.myapplication.network.BookshelfApiService

class FakeBookshelfApiService : BookshelfApiService {
    override suspend fun getAllBooks(): VolumeInfo {
        return FakeDataSource.volumeInfo
    }

    override suspend fun getBookInfo(id: String): BookInfo {
        return FakeDataSource.bookInfo
    }
}