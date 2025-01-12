package com.example.filmfinder.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.filmfinder.data.model.Movie
import com.example.filmfinder.navigation.MovieScreenRoute
import com.example.filmfinder.ui.viewmodel_list.MovieListViewModel
import com.example.filmfinder.ui.viewmodel_list.MovieListViewModelEvent

@Composable
fun MovieList(movies: List<Movie>, viewModel: MovieListViewModel, navController: NavController) {

    val currentOrder = viewModel.currentOrder.value

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            SortDropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                movieOrder = currentOrder.order,
                onOrderChange = {
                    viewModel.onEvent(MovieListViewModelEvent.Order(it))
                }
            )
        }
        items(movies) { movie ->
            MovieItem(
                movie,
                onClick = { navController.navigate(MovieScreenRoute(movie.id)) }
            )
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight(0.3f)
                    .padding(top = 2.dp, bottom = 24.dp),
                onClick = { viewModel.onEvent(MovieListViewModelEvent.LoadNextPage) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(
                        35,
                        35,
                        35
                    )
                )
            ) {
                Text(
                    text = "Load More",
                    color = Color.White
                )
            }
        }
        item {
            Spacer(Modifier.height(24.dp))
        }
    }
}