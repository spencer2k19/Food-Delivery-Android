package com.example.fooddelivery.presentation.cart

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.common.extensions.toPriceString
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.home.HomeActivity
import com.example.fooddelivery.presentation.login.LoginViewModel
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartView(
    navController: NavController? = null,
    viewModel: CartViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    var openDialog by remember{ mutableStateOf(false) }
    var openSuccessfullyDialog by remember {
        mutableStateOf(false)
    }
    val orderState = viewModel.orderState.value
    val snackbarHostState = remember{
        SnackbarHostState()
    }




    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest {event ->
            when(event) {
                is CartViewModel.UIOrderEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
                is CartViewModel.UIOrderEvent.ShowSuccessfullyDialog -> {
                   //openSuccessfullyDialog = true
                }
            }
        }
    }

    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    },topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "My cart", fontSize = 18.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->
            var comment by remember{ mutableStateOf("") }
             LazyColumn(contentPadding = PaddingValues(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                }

                items(state.data) {food->
                    CartItemView(food, addQuantityCallback = {
                        viewModel.increaseFoodQuantity(food.id)
                    }, reduceQuantityCallback = {
                        viewModel.removeFoodFromCart(food.id)
                    })
                }

                 item {
                     Spacer(modifier = Modifier.height(20.dp))
                     Text(text = "Leave a comment", fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                         fontFamily = Satoshi)
                     Spacer(modifier = Modifier.height(20.dp))
                     OutlinedTextField(value = comment, onValueChange = {
                         comment = it
                     }, modifier = Modifier
                         .fillMaxWidth()
                         .height(100.dp),

                         shape = RoundedCornerShape(10.dp),
                         colors = TextFieldDefaults.outlinedTextFieldColors(
                             containerColor = Color(0xFFF9F9F9),
                             unfocusedBorderColor = Color(0xFFF9F9F9),
                             focusedBorderColor = Color(0xFFF9F9F9),
                         ),

                         placeholder = {
                             Text(text = "Comments...", fontSize = 16.sp,
                                 fontFamily = Satoshi,
                                 fontWeight = FontWeight.W400,
                                 color = Color(0xFF94979F))
                         },

                         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,),
                         singleLine = false, maxLines = 5,

                     )

                     Spacer(modifier = Modifier.height(20.dp))

                     Text(
                         text = "Total: ${state.total.toPriceString()} $",
                         fontFamily = Satoshi,
                         fontWeight = FontWeight.Bold,
                         fontSize = 17.sp,
                         textAlign = TextAlign.Center,
                         modifier = Modifier.fillMaxWidth()
                     )

                     Spacer(modifier = Modifier.height(30.dp))

                     Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                         CustomFilledButton(text = "Place my order", onClick = {
                             openDialog = true
                         }, isLoading = orderState.isLoading)
                     }


                     if(openDialog) {
                         AlertDialog(onDismissRequest = {

                         }, confirmButton = {
                             TextButton(onClick = {
                                 openDialog = false
                                 viewModel.addOrder(comment,state.data)
                             }) {
                                 Text(text = "Yes",
                                     fontSize = 14.sp,
                                     fontFamily = Satoshi,
                                     fontWeight = FontWeight.SemiBold,
                                     color = PrimaryColor)
                             }
                         },
                             title = {
                                 Text(text = "Order", fontSize = 15.sp,
                                     fontFamily = Satoshi,
                                     fontWeight = FontWeight.SemiBold)
                             },
                             text = {
                                 Text(text = "Confirm this order ? ",
                                     fontSize = 14.sp,
                                     fontFamily = Satoshi,
                                     fontWeight = FontWeight.Normal)
                             },
                             dismissButton = {
                                 TextButton(onClick = {
                                     openDialog = false
                                 }) {
                                     Text(text = "No",
                                         fontSize = 14.sp,
                                         fontFamily = Satoshi,
                                         fontWeight = FontWeight.SemiBold,
                                         )
                                 }
                             }, containerColor = Color.White


                             )
                     }


                     if(orderState.success.isNotEmpty()) {
                         AlertDialog(onDismissRequest = {

                         }, confirmButton = {
                             TextButton(onClick = {
                                 openDialog = false
                                navController?.popBackStack()
                             }) {
                                 Text(text = "OK",
                                     fontSize = 14.sp,
                                     fontFamily = Satoshi,
                                     fontWeight = FontWeight.SemiBold,
                                     color = PrimaryColor)
                             }
                         },

                             text = {
                                 Text(text = orderState.success,
                                     fontSize = 14.sp,
                                     fontFamily = Satoshi,
                                     fontWeight = FontWeight.Normal)
                             },
                            containerColor = Color.White


                         )
                     }



                 }
            }


    }
}


@Preview
@Composable
fun PrevCartView() {
    CartView()
}