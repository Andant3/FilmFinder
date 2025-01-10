package com.example.filmfinder.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            val (image, title, overview, rating, dots) = createRefs()

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                contentDescription = "Movie Image",
                Modifier.constrainAs(image) {

                    top.linkTo(parent.top, margin = 6.dp)
                    start.linkTo(parent.start, margin = 6.dp)
                    bottom.linkTo(parent.bottom)

                }
            )

            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 16.dp)
                },
                text = movie.title,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                modifier = Modifier.constrainAs(overview) {
                    top.linkTo(title.bottom, margin = 6.dp)
                    start.linkTo(title.start)
                    end.linkTo(parent.end, margin = 6.dp)
                    bottom.linkTo(rating.top, margin = 10.dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
                text = movie.overview,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                modifier = Modifier
                    .constrainAs(dots) {
                        top.linkTo(overview.bottom, margin = -(8.dp))
                        start.linkTo(overview.start)
                    },
                text = if (movie.overview.length > 174) "..."
                else ""
            )
            RatingComposable(
                movie.rating,
                Modifier
                    .constrainAs(rating) {
                        bottom.linkTo(parent.bottom, margin = 12.dp)
                        end.linkTo(parent.end, margin = 12.dp)
                    })
        }

    }
}
