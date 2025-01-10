package com.example.filmfinder.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil3.compose.AsyncImage
import com.example.filmfinder.R
import com.example.filmfinder.ui.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel, id: Int) {

    val movie = viewModel.getMovieById(id)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {

        val (title_text, overview_text, poster, backdrop, star, rating) = createRefs()

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original${movie.backdropPath}",
            contentDescription = "Movie Background Image",
            Modifier.constrainAs(backdrop) {

                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
                .graphicsLayer(alpha = 0.5f)
        )

        AsyncImage(
            model = "https://image.tmdb.org/t/p/w300${movie.posterPath}",
            contentDescription = "Movie Image",
            Modifier.constrainAs(poster) {

                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)

            }
        )

        Text(
            modifier = Modifier.constrainAs(title_text){
                top.linkTo(poster.top)
                start.linkTo(poster.end, margin = 5.dp)
                end.linkTo(backdrop.end)

                width = Dimension.wrapContent
                height = Dimension.wrapContent
            },
            text = movie.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            modifier = Modifier.constrainAs(overview_text){
                top.linkTo(backdrop.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 10.dp)
            },
            text = movie.overview,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 2.em,
                    lineBreak = LineBreak.Paragraph
                )
            ),
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color.White
        )

        Image(
            painter = painterResource(R.drawable.star_full),
            contentDescription = "Rating Star",
            modifier = Modifier.constrainAs(star){
                end.linkTo(backdrop.end, margin = 10.dp)
                bottom.linkTo(backdrop.bottom, margin = 10.dp)
            }
                .size(72.dp)
        )

        Text(
            text = movie.rating.toString().substring(0, 3),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier.constrainAs(rating){
                top.linkTo(star.top, margin = 8.dp)
                start.linkTo(star.start)
                end.linkTo(star.end)
                bottom.linkTo(star.bottom)
            }
        )
    }
}
