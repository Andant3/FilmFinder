package com.example.filmfinder.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmfinder.R

@Composable
fun RatingComposable(rating: Double, modifier: Modifier) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$rating".substring(0, 3),
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        )
        Column(
            Modifier.padding(start = 5.dp)
        ) {
            Row {
                StarImage(rating, 1)
                StarImage(rating, 2)
                StarImage(rating, 3)
                StarImage(rating, 4)
                StarImage(rating, 5)
            }
            Row {
                StarImage(rating, 6)
                StarImage(rating, 7)
                StarImage(rating, 8)
                StarImage(rating, 9)
                StarImage(rating, 10)
            }
        }
    }
}

@Composable
fun StarImage(rating: Double, num: Int){
    Image(
        painter = when {
            rating >= num-0.2 -> {
                painterResource(R.drawable.star_full)
            }

            rating >= num-0.7 -> {
                painterResource(R.drawable.star_half)
            }

            else -> {
                painterResource(R.drawable.star_empty)
            }
        },
        contentDescription = "Rating Star Image",
        modifier = Modifier
            .padding(2.dp)
            .size(22.dp)
    )
}

@Preview
@Composable
fun RatingPreview() {
    RatingComposable(
        8.3,
        Modifier.fillMaxWidth()
    )
}