package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibiansapp.R
import com.example.amphibiansapp.data.FakeDataSource
import com.example.amphibiansapp.model.Amphibian

@Composable
fun HomeScreen(amphibiansUiState: AmphibiansUiState){
    when(amphibiansUiState){
        is AmphibiansUiState.Loading -> LoadingScreen()
        is AmphibiansUiState.Success -> AmphibiansList(content = amphibiansUiState.amphibians)
        is AmphibiansUiState.Error -> ErrorScreen()
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian)
    {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(360.dp)
            ,
        elevation = 6.dp
    ){
        Column(
           horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = amphibian.name + "(${amphibian.type})",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(top = 12.dp)
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(12.dp),
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(amphibian.imgSrc)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                placeholder = painterResource(id = R.drawable.loading_img),
                error = painterResource(id = R.drawable.ic_connection_error),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun AmphibiansList(content: List<Amphibian>){
    LazyColumn{
        items(
            items = content,
        ){
            item -> AmphibianCard(item)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.error_loading))
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    AmphibiansList(content = FakeDataSource.amphibianList)
}