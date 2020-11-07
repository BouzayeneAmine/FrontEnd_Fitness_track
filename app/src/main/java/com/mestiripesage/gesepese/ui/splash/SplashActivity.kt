package com.mestiripesage.gesepese.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.mestiripesage.gesepese.R
import com.mestiripesage.gesepese.ui.login.LoginActivity


class SplashActivity : AppCompatActivity() {

    public var SPLASH_DISPLAY_LENGTH = 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())

    }
}