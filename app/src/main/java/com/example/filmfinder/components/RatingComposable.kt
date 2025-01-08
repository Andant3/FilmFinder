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
                Image(
                    painter = when {
                        rating >= 0.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 0.3 -> {
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
                Image(
                    painter = when {
                        rating >= 1.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 1.3 -> {
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
                Image(
                    painter = when {
                        rating >= 2.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 2.3 -> {
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
                Image(
                    painter = when {
                        rating >= 3.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 3.3 -> {
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
                Image(
                    painter = when {
                        rating >= 4.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 4.3 -> {
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
            Row {
                Image(
                    painter = when {
                        rating >= 5.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 5.3 -> {
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
                Image(
                    painter = when {
                        rating >= 6.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 6.3 -> {
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
                Image(
                    painter = when {
                        rating >= 7.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 7.3 -> {
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
                Image(
                    painter = when {
                        rating >= 8.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 8.3 -> {
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
                Image(
                    painter = when {
                        rating >= 9.8 -> {
                            painterResource(R.drawable.star_full)
                        }

                        rating >= 9.3 -> {
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
        }
    }
}

@Preview
@Composable
fun RatingPreview() {
    RatingComposable(
        6.8,
        Modifier.fillMaxWidth()
    )
}