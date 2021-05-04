package io.giodude.fishdakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isVisible
import com.kaiguanjs.utils.YQCUtils

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        val ivLogo = findViewById<ImageView>(R.id.iv_logo)



        YQCUtils.splashAction(this) { version, downUrl ->
//            ivLogo.isVisible = true
//            ivLogo.alpha = 0f
//
//            ivLogo.animate().setDuration(1500).alpha(1f).withEndAction{

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)

                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()

        }

    }
}