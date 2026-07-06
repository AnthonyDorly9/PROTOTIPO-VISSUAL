package com.example.prototipo_vissual.ui.attractor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AttractorScreen(
    onTriggered: () -> Unit,
    viewModel: AttractorViewModel = viewModel()
) {
    val isListening by viewModel.isListening.collectAsState()

    DisposableEffect(Unit) {
        viewModel.startListening()
        onDispose { viewModel.stopListening() }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable { viewModel.onTouchDetected(onTriggered) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isListening) "Toca la pantalla o dime un comando" else "BTOUCH Showcase",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
