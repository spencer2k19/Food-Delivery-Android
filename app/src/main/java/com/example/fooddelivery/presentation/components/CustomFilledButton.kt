package com.example.fooddelivery.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor

@Composable
fun CustomFilledButton(
    text:String,
    onClick:()->Unit,
    color: Color = PrimaryColor,
    textColor: Color = Color.White,
    isLoading: Boolean = false

) {



    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .height(50.dp)


    ) {
        if(isLoading) {
            CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp,
                modifier = Modifier.width(24.dp).height(24.dp))
        } else {
            Text(text = text, color = textColor)
        }

    }
}

@Preview
@Composable
fun PrevFilledButton() {
    CustomFilledButton(text = "Test", onClick = {}, isLoading = true)
}