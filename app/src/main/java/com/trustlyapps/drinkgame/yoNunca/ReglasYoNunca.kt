package com.trustlyapps.drinkgame.yoNunca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.trustlyapps.drinkgame.R

class ReglasYoNunca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reglas_yo_nunca)

        val toolbar = findViewById<Toolbar>(R.id.tlRyoNunca)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
    }
}