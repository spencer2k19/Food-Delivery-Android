package com.example.fooddelivery.presentation.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.fooddelivery.R
import com.example.fooddelivery.common.PrefSingleton
import com.example.fooddelivery.presentation.home.HomeActivity
import com.example.fooddelivery.presentation.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        lifecycleScope.launch {
            delay(3000)

            if(PrefSingleton.getTokenData() != null) {
                val intent = Intent(this@IntroActivity,HomeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }

            finish()
        }
    }
}