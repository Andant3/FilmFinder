package com.example.filmfinder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.filmfinder.data.model.Movie

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = onClick
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w400${movie.posterPath}",
                    contentDescription = "Movie Image",
                    Modifier.padding(10.dp)
                )

                RatingComposable(
                    movie.rating
                )
            }

            Column {

                Text(
                    modifier = Modifier.padding(start = 12.dp, top = 4.dp),
                    text = movie.title,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = movie.overview,
                    style = TextStyle(
                        lineHeight = 1.5.em
                    ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }
}
