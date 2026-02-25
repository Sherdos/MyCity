package com.example.mycity.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycity.models.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    title: String,
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(title) }) }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Choose a category",
                style = MaterialTheme.typography.titleLarge
            )

            categories.forEach { category ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategoryClick(category) }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(category.icon, contentDescription = null)
                        Spacer(Modifier.width(12.dp))
                        Text(category.title, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}