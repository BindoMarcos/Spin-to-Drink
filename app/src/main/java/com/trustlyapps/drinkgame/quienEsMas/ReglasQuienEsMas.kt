package com.trustlyapps.drinkgame.quienEsMas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.trustlyapps.drinkgame.R

class ReglasQuienEsMas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reglas_quien_es_mas)

        val toolbar = findViewById<Toolbar>(R.id.tlRquienEs)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

    }
}