package com.example.filmfinder.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.filmfinder.ui.viewmodel_list.MovieOrder


@Composable
fun SortDropdownMenu(
    modifier: Modifier,
    movieOrder: MovieOrder = MovieOrder.Popularity,
    onOrderChange: (MovieOrder) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Rating") },
                onClick = {
                    movieOrder is MovieOrder.Rating
                    onOrderChange(MovieOrder.Rating)
                }
            )
            DropdownMenuItem(
                text = { Text("Popularity") },
                onClick = {
                    movieOrder is MovieOrder.Popularity
                    onOrderChange(MovieOrder.Popularity)
                }
            )
        }
    }
}