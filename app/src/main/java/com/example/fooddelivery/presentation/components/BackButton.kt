package com.example.fooddelivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButton(onClick: () -> Unit) {

    Card(shape = RoundedCornerShape(12.dp), onClick = {
                                                      onClick()
    },elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ) ,colors = CardDefaults.cardColors(
        containerColor = Color.White,

    ), modifier = Modifier
        .width(40.dp)
        .height(40.dp)) {
        Image(imageVector = Icons.Default.ArrowBack , contentDescription = "",
            modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally)
        )
    }

}


@Preview
@Composable
fun PrevBackBtn() {
    BackButton {

    }
}