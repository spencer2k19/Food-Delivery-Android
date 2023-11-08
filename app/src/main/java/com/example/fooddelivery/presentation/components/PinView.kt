package com.example.fooddelivery.presentation.components


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun PinView(
    pinText: String,
    onPinTextChange: (String) -> Unit,
    digitColor: Color = Color(0x1A181E22),
    digitTextColor: Color = Color.Black,
    digitSize: TextUnit = 16.sp,
    widthSize: Dp = 75.dp,
    heightSize: Dp = 60.dp,
    digitCount: Int = 4,
) {

    val focusRequester = FocusRequester()


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()

    }
    BasicTextField(value = pinText,
        onValueChange = onPinTextChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = Modifier.focusRequester(focusRequester),

        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                repeat(digitCount) { index ->

                    DigitView(index, pinText, digitColor,digitTextColor, digitSize,widthSize,heightSize )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        })
}


@Composable
private fun DigitView(
    index: Int,
    pinText: String,
    digitColor: Color,
    digitTextColor: Color,
    digitSize: TextUnit,
    widthSize: Dp,
    heightSize: Dp


) {

    val isCursorVisible = index == pinText.length
    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }
    val modifier =
        Modifier
            .width(widthSize)
            .height(heightSize)

            .border(
                width = 1.dp,
                color = digitColor,
                shape = RoundedCornerShape(12.dp)
            )

            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    Box(modifier = modifier) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = if (isCursorVisible) cursorSymbol else if(pinText.length >= index) pinText[index].toString() else "",
            color = if (isCursorVisible) digitColor else  digitTextColor,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = digitSize,
            fontWeight = FontWeight.W700,
            textAlign = TextAlign.Center)
    }


    /* Column(horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center) {
         Text(
             text = if (index >= pinText.length) "" else pinText[index].toString(),
             color = digitTextColor,
             modifier = modifier,
             style = MaterialTheme.typography.body1,

             fontSize = digitSize,
             textAlign = TextAlign.Center)

     }*/
}


@Preview(showBackground = true)
@Composable
fun DefaultPinTheme() {
    val input = remember {
        mutableStateOf("1234")
    }
    PinView(pinText = input.value, onPinTextChange = {input.value = it},

        )
}
