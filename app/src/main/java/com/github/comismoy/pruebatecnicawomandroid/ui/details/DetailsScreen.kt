package com.github.comismoy.pruebatecnicawomandroid.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.comismoy.pruebatecnicawomandroid.R
import com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation.ScreenRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, breedName: String) {
    val viewModel: DogBreedsImagesViewModel = hiltViewModel()
    val dogBreedsImagesState by viewModel.dogBreedsImages.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getDogBreedsImages(breedName.trim())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = breedName.uppercase(),
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack(
                            ScreenRoutes.Home.screenRoutes,
                            inclusive = false
                        )
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            DogBreedsImagesList(dogBreedsImagesState)
        }
    }
}

@Composable
fun DogBreedsImagesList(dogBreedsImagesState: DogBreedsImagesState) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (dogBreedsImagesState.dogBreedsImagesList?.breedsImages.isNullOrEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(64.dp)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(dogBreedsImagesState.dogBreedsImagesList!!.breedsImages.size) { index ->
                    val breedImages = dogBreedsImagesState.dogBreedsImagesList.breedsImages[index]
                    DogBreedImagesCard(breedImages)
                }
            }
        }
    }
}

@Composable
fun DogBreedImagesCard(breedImages: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(200.dp)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(breedImages)
                    .crossfade(true)
                    .placeholder(R.drawable.placelolder)
                    .memoryCacheKey(breedImages)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}