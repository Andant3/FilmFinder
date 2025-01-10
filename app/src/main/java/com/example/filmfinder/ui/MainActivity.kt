package com.example.filmfinder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.filmfinder.components.MovieScreen
import com.example.filmfinder.components.MoviesListScreen
import com.example.filmfinder.navigation.MovieListScreenRoute
import com.example.filmfinder.navigation.MovieScreenRoute
import com.example.filmfinder.data.repository.Repository
import com.example.filmfinder.ui.theme.FilmFinderTheme
import com.example.filmfinder.ui.viewmodel.MovieListViewModel
import com.example.filmfinder.ui.viewmodel.MovieViewModel
import com.example.filmfinder.ui.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository(applicationContext)
        val viewModelFactory = MovieViewModelFactory(repository)
        val movieListViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieListViewModel::class.java]
        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            FilmFinderTheme {
                Column {
                    CustomHeader()

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = MovieListScreenRoute
                    ) {
                        composable<MovieListScreenRoute> {
                            MoviesListScreen(movieListViewModel, navController)
                        }
                        composable<MovieScreenRoute> {
                            val args = it.toRoute<MovieScreenRoute>()
                            MovieScreen(movieViewModel, args.id)
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun CustomHeader() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FilmFinder App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Popular",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
