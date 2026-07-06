package com.example.prototipo_vissual.ui.selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectorScreen(
    onVerticalSelected: (Vertical) -> Unit,
    onBackToAttractor: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¿Qué te gustaría ver?",
            style = MaterialTheme.typography.headlineSmall
        )
        Button(onClick = { onVerticalSelected(Vertical.EDUCACION) }) {
            Text("Educación")
        }
        Button(onClick = { onVerticalSelected(Vertical.CORPORATIVO) }) {
            Text("Corporativo")
        }
        Button(onClick = { onVerticalSelected(Vertical.RETAIL) }) {
            Text("Retail")
        }
    }
}
