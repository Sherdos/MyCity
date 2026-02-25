package com.example.mycity.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycity.models.Place
import androidx.compose.foundation.Image
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailsScreen(
    place: Place?,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(place?.name ?: "Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (place == null) {
            Box(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No place selected.")
            }
            return@Scaffold
        }

        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
            Text(place.name, style = MaterialTheme.typography.headlineSmall)
            Text(place.details, style = MaterialTheme.typography.bodyLarge)
            Divider()
            Text("Address", style = MaterialTheme.typography.titleMedium)
            Text(place.address, style = MaterialTheme.typography.bodyMedium)
        }
    }
}