package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.amphibiansapp.R
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AmphibiansApp(viewModel: AmphibiansViewModel){
    Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = {Text(stringResource(R.string.topbar_name_amphibians))})
                }
        ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel()
            HomeScreen(amphibiansUiState = amphibiansViewModel.amphibiansUiState)
        }
    }
}