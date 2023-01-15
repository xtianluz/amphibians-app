package com.example.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ui.screens.AmphibianCard
import com.example.amphibiansapp.ui.screens.AmphibiansApp
import com.example.amphibiansapp.ui.screens.AmphibiansViewModel
import com.example.amphibiansapp.ui.screens.HomeScreen
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansAppTheme {
                val viewModel: AmphibiansViewModel =
                    viewModel(factory = AmphibiansViewModel.Factory)
                    AmphibiansApp(viewModel = viewModel)
            }
        }
    }
}
