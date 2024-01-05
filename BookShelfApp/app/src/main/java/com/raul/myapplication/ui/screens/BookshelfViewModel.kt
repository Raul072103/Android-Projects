package com.raul.myapplication.ui.screens

import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.raul.BookShelfApplication
import com.raul.myapplication.data.BookshelfAppRepository
import com.raul.myapplication.model.BookInfo
import com.raul.myapplication.model.VolumeInfo
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface BookshelfUiSate{
    data class Success(val bookUrls: MutableList<String>): BookshelfUiSate
    object Error: BookshelfUiSate
    object Loading: BookshelfUiSate
}

class BookshelfViewModel(
private val bookshelfAppRepository: BookshelfAppRepository
) : ViewModel() {

    var bookshelfUiSate: BookshelfUiSate by mutableStateOf(BookshelfUiSate.Loading)
        private set

    init {
        getBookshelfPhotos()
    }

    fun getBookshelfPhotos() {
        viewModelScope.launch {
            bookshelfUiSate = BookshelfUiSate.Loading
            bookshelfUiSate =
                try {
                    var bookUrls: MutableList<String> = mutableListOf()
                    val volumeInfo: VolumeInfo = bookshelfAppRepository.getAllBooks()
                    volumeInfo.items.forEach {item ->
                        val bookInfo: BookInfo = bookshelfAppRepository.getBookUrl(item.id)
                        var currentBookUrl: String = bookInfo.volumeInfo.imageLinks.thumbnail
                        if (!currentBookUrl.contains("https"))
                            currentBookUrl = currentBookUrl.replace("http", "https")
                        bookUrls.add(currentBookUrl)
                    }

                    BookshelfUiSate.Success(bookUrls)
                }
                catch (e: IOException) {
                    BookshelfUiSate.Error
                }
                catch (e: HttpException) {
                    BookshelfUiSate.Error
                }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookShelfApplication)
                val bookshelfAppRepository = application.container.bookshelfAppRepository
                BookshelfViewModel(bookshelfAppRepository = bookshelfAppRepository)
            }
        }
    }


}