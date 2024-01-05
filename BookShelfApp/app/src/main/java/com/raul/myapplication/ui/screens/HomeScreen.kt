package com.raul.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.raul.myapplication.R

@Composable
fun HomeScreen(
    bookshelfUiSate: BookshelfUiSate,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (bookshelfUiSate) {
        is BookshelfUiSate.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BookshelfUiSate.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
        is BookshelfUiSate.Success -> PhotosGridScreen(imageUrls = bookshelfUiSate.bookUrls, modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.loading_img), 
        contentDescription = "Pictures loading"
    )
}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = "Error loading pictures"
        )
        Text(
            text = "Loading failed"
        )
        Button(onClick = retryAction ) {
            Text(text = "Retry")
        }
    }
    
}

@Composable
fun PhotosGridScreen(
    imageUrls: List<String>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = imageUrls) {
            item ->  BookPhotoCard(photoUrl = item,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f))
        }
    }

}

@Composable
fun BookPhotoCard(
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photoUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Book photo",
        contentScale = ContentScale.Crop,
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.loading_img),
        modifier = Modifier.fillMaxWidth()
    )

}

@Preview
@Composable
fun previewLoadingScreen() {
    LoadingScreen()
}

@Preview
@Composable
fun previewErrorScreen() {
    ErrorScreen(retryAction = { /*TODO*/ })
}

@Preview
@Composable
fun previewSuccessScreen() {
    val mockData = mutableListOf<String>("fasfasf", "fafas")
    PhotosGridScreen(imageUrls = mockData)
}