package com.raul.amphibians.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.raul.amphibians.R
import com.raul.amphibians.model.AmphibiansInfo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
) {

    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen()
        is AmphibiansUiState.Success -> ResultScreen(amphibiansUiState.amphibians)
        is AmphibiansUiState.Error -> ErrorScreen()
    }

}  

@Composable
fun AmphibianInfoBox(amphibiansInfo: AmphibiansInfo) {

    Box (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
        
    ){
        Column {
            Text(text = amphibiansInfo.name)
            AmphibiansPhotoCard(photoSrc = amphibiansInfo.imgSrc)
            Text(text = amphibiansInfo.description)
        }
    }

}

@Composable
fun AmphibiansPhotoCard(photoSrc: String) {
    Card (
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photoSrc)
                .crossfade(true)
                .build(),
            contentDescription = "Amphibians Photo",
            contentScale = ContentScale.Crop,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img),
            modifier = Modifier.fillMaxWidth()

        )
    }
}
@Composable
fun ResultScreen(
    amphibiansList: List<AmphibiansInfo>
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        content = {
            items(amphibiansList.size) {index ->
                AmphibianInfoBox(amphibiansInfo = amphibiansList[index])
            }
        }
    )
}

@Composable
fun LoadingScreen() {

}

@Composable
fun ErrorScreen() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewHomeScreen() {
    val name1: String = "Rex"
    val type1: String = "Dog"
    val description1: String = "He likes to run"
    val imgSrc1: String = "somewhereintheweb.one"

    val name2: String = "Vlad"
    val type2: String = "Cat"
    val description2: String = "He likes to sleep"
    val imgSrc2: String = "somewhereintheweb.two"

    val amphibiansList = listOf<AmphibiansInfo>(
        AmphibiansInfo(
            name = name1,
            type = type1,
            description = description1,
            imgSrc = imgSrc1
        ),
        AmphibiansInfo(
            name = name2,
            type = type2,
            description = description2,
            imgSrc = imgSrc2
        )
    )
    ResultScreen(amphibiansList = amphibiansList)
}