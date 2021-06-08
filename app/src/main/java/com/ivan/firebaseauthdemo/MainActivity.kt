package com.ivan.firebaseauthdemo

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.View.VISIBLE
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var bookITextView : TextView
    private lateinit var loadingProgressBar : ProgressBar
    private lateinit var rootView : RelativeLayout
    private lateinit var bookIconImageView : ImageView
    private lateinit var afterAnimationView : RelativeLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        bookITextView = findViewById(R.id.bookITextView)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)
        rootView = findViewById(R.id.rootView)
        bookIconImageView = findViewById(R.id.bookIconImageView)





        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                bookITextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorSplashText))
                bookIconImageView.setImageResource(R.drawable.background_color_book)
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()
    }

    private fun startAnimation() {
        afterAnimationView = findViewById(R.id.afterAnimationView)
        bookIconImageView.animate().apply {
            x(50f)
            y(100f)
            duration = 100
        }.setListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
            }
            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }

}
