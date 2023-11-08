package com.example.fooddelivery.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddelivery.presentation.StartView
import com.example.fooddelivery.presentation.change_password.ChangePasswordView
import com.example.fooddelivery.presentation.change_password.CongratsPasswordChanged
import com.example.fooddelivery.presentation.credit_card.CreditCardView
import com.example.fooddelivery.presentation.forgot_password.ForgotPasswordView
import com.example.fooddelivery.presentation.login.LoginView
import com.example.fooddelivery.presentation.payment.PaymentMethodView
import com.example.fooddelivery.presentation.register.BioView
import com.example.fooddelivery.presentation.register.RegisterView

@Composable
fun FoodNavHost(
    navController:NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Start.route) {
        composable(Start.route) {
            StartView(navController)
        }

        composable(Login.route) {
            LoginView(navController)
        }

        composable(Register.route) {
            RegisterView(navController)
        }

        composable(Bio.route) {
            BioView(navController)
        }

        composable(Payment.route) {
            PaymentMethodView(navController)
        }

        composable(CreditCart.route) {
            CreditCardView(navController)
        }

        composable(ForgotPassword.route) {
            ForgotPasswordView(navController)
        }

        composable(ChangePassword.route) {
            ChangePasswordView(navController)
        }

        composable(CongratsChangePassword.route) {
            CongratsPasswordChanged(navController)
        }


    }
}