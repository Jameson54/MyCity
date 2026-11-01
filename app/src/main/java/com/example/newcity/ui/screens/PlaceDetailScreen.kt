package com.example.mycity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.ui.MyCityUiState

@Composable
fun DetailScreen(uiState: MyCityUiState) {
    val place = uiState.selectedPlace
    if (place != null) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Image(
                painter = painterResource(id = place.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Название
            Text(
                text = stringResource(id = place.nameResId),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = place.descriptionResId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}