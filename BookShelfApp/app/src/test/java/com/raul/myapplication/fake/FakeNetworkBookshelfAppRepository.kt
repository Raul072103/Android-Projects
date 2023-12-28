package com.raul.myapplication.fake

import com.raul.myapplication.data.BookshelfAppRepository
import com.raul.myapplication.data.NetworkBookshelfAppRepository
import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo

class FakeNetworkBookshelfAppRepository : BookshelfAppRepository {
    override suspend fun getAllBooks(): VolumeInfo {
        return FakeDataSource.volumeInfo
    }

    override suspend fun getBookUrl(id: String): BookInfo {
        return FakeDataSource.booksMap.getValue(id)
    }
}