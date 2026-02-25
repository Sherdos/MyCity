package com.example.mycity.ui.theme.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesScreen(
    categoryTitle: String,
    places: List<Place>,
    onBack: () -> Unit,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(categoryTitle) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            places.forEach { place ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPlaceClick(place) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        // LEFT IMAGE
                        Image(
                            painter = painterResource(place.imageRes),
                            contentDescription = place.name,
                            modifier = Modifier
                                .size(90.dp) // square thumbnail
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )

                        // RIGHT TEXT
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Text(
                                place.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(Modifier.height(6.dp))

                            Text(
                                place.shortDescription,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 2
                            )
                        }
                    }
                }
            }
        }
    }
}