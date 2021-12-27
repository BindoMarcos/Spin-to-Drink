package com.trustlyapps.drinkgame

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.ColorUtils
import jp.wasabeef.blurry.Blurry
import android.content.Intent
import android.view.WindowManager


class PopUpWindow : AppCompatActivity() {
    private var popupTitle = ""
    private var popupText = ""
    private var popupButton = ""
    private var darkStatusBar = false

    private var popupWindowBackground: View? = null
    private var popupWindowViewWithBorder: View? = null
    private var popupWindowButton: Button? = null
    private var popupWindowTitle: TextView? = null
    private var popupWindowText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        setContentView(R.layout.activity_pop_up_window)



        // Get the data
        val bundle = intent.extras
        popupTitle = bundle?.getString("popuptitle", "Title") ?: ""
        popupText = bundle?.getString("popuptext", "Text") ?: ""
        popupButton = bundle?.getString("popupbtn", "OK") ?: ""
        darkStatusBar = bundle?.getBoolean("darkstatusbar", false) ?: false

        //call the views
        popupWindowButton = findViewById(R.id.popup_window_button)
        popupWindowTitle = findViewById(R.id.popup_window_title)
        popupWindowText = findViewById(R.id.popup_window_text)

        // Set the data
        popupWindowTitle?.text = popupTitle
        popupWindowText?.text = popupText
        popupWindowButton?.text = popupButton


        // Fade animation for the background of Popup Window
        val alpha = 100 //between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, alphaColor)
        colorAnimation.duration = 500 // milliseconds

        colorAnimation.addUpdateListener { animator ->
            popupWindowBackground = findViewById(R.id.popup_window_background_container)
            popupWindowBackground?.setBackgroundColor(animator.animatedValue as Int)

        }
        colorAnimation.start()


        // Fade animation for the Popup Window
        popupWindowViewWithBorder = findViewById(R.id.popup_window_view_with_border)
        popupWindowViewWithBorder?.alpha = 0f
        popupWindowViewWithBorder?.animate()?.alpha(1f)?.setDuration(500)?.setInterpolator(
            DecelerateInterpolator()
        )?.start()


        // Close the Popup Window when you press the button
        popupWindowButton?.setOnClickListener {
            onBackPressed()
        }
    }
    

    override fun onBackPressed() {
        popupWindowViewWithBorder = findViewById(R.id.popup_window_view_with_border)

        // Fade animation for the background of Popup Window when you press the back button
        val alpha = 100 // between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), alphaColor, Color.TRANSPARENT)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            popupWindowBackground = findViewById(R.id.popup_window_background_container)
            popupWindowBackground?.setBackgroundColor(
                animator.animatedValue as Int
            )
        }

        // Fade animation for the Popup Window when you press the back button

        popupWindowViewWithBorder?.animate()?.alpha(0f)?.setDuration(500)?.setInterpolator(
            DecelerateInterpolator()
        )?.start()

        // After animation finish, close the Activity
        colorAnimation.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                finish()
                overridePendingTransition(0, 0)
            }
        })
        colorAnimation.start()
    }

}



