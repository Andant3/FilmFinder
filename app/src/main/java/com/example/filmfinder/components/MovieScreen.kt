package com.example.filmfinder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage

@Composable
fun MovieScreen(
    title: String,
    overview: String,
    posterPath: String,
    backdropPath: String
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {

        val (title_text, overview_text, poster, backdrop) = createRefs()

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original${backdropPath}",
            contentDescription = "Movie Image",
            Modifier.constrainAs(backdrop) {

                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
                .graphicsLayer(alpha = 0.5f)
        )

        AsyncImage(
            model = "https://image.tmdb.org/t/p/w300${posterPath}",
            contentDescription = "Movie Image",
            Modifier.constrainAs(poster) {

                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)

            }
        )

        Text(
            modifier = Modifier.constrainAs(title_text){
                top.linkTo(poster.top)
                start.linkTo(poster.end, margin = 16.dp)
            },
            text = title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            modifier = Modifier.constrainAs(overview_text){
                top.linkTo(backdrop.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 10.dp)
            },
            text = overview,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }

}