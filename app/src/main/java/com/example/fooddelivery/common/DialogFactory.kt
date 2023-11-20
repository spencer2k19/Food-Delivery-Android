package com.example.fooddelivery.common

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.main.MainActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object DialogFactory {
    private var alertDialog: AlertDialog? = null
    fun showDialog(context: Context, title: String?, message: String?): AlertDialog? {
        val titre = StringBuilder()
        titre.append(title)
        val foregroundColorSpan = ForegroundColorSpan(context.resources.getColor(R.color.purple_200))
        val ssBuilder = SpannableStringBuilder(titre)
        ssBuilder.setSpan(
            foregroundColorSpan,
            0,
            titre.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        val alertBuilder = AlertDialog.Builder(context)
        alertBuilder.setTitle(ssBuilder)
        alertBuilder.setMessage(message)
        alertBuilder.setCancelable(false)
        //alertBuilder.setIcon(R.drawable.ic_report_problem_black_48dp);
        alertDialog = alertBuilder.create()
        return alertDialog
    }

    fun showLogoutDialog(context: Context) {
        val alert = MaterialAlertDialogBuilder(context,R.style.DialogTheme)
            .setTitle("Déconnexion")
            .setMessage("Oops...Votre session a expiré")
            .setPositiveButton(R.string.ok
            ) { dialog, _ ->
                dialog.dismiss()
                val intent = Intent(context, MainActivity::class.java)
                intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(intent)
            }
            .show()

    }
}