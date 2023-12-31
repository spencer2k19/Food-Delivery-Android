package com.example.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fooddelivery.R
import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.common.extensions.toHumanDateFromTZ
import com.example.fooddelivery.domain.model.Testimonial
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun TestimonialItemView(
    testimonial: Testimonial? = null
) {
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ), shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(bottom = 10.dp)


    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.Top) {

            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("${Endpoints.ASSETS_URL}/${testimonial?.avatar}")
                .crossfade(true).build(), contentDescription = testimonial?.authorName?:"",
                    error = painterResource(id = R.drawable.testimonial1)
                )



            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${testimonial?.authorName}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = Satoshi,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF181E22),
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painter = painterResource(id = R.drawable.star), contentDescription = "",
                        tint = PrimaryColor)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "${testimonial?.rating}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = Satoshi,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF0D5EF9),
                        )
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${testimonial?.dateCreated?.toHumanDateFromTZ()}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF181E22),
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${testimonial?.content}",
                    modifier = Modifier.padding(end = 15.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF181E22),
                    )
                )
            }
        }
    }
}


@Preview
@Composable
fun PrevTestimonialItemView() {
    TestimonialItemView()
}