package com.trustlyapps.drinkgame

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val prevStarted: String = "yes"
    private var acceptConditions: String = ""


    override fun onResume() {
        super.onResume()

        val bAccept = findViewById<Button>(R.id.bAccept)

        val sharedpreferences: SharedPreferences =
            getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)

        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor: SharedPreferences.Editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()

            bAccept.setOnClickListener{
                moveToMain()
                acceptConditions = "Yes"
            }
        } else {
            moveToMain()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reglas)
    }


    private fun moveToMain(){
        startActivity(Intent(this, GameActivity::class.java))
    }
}