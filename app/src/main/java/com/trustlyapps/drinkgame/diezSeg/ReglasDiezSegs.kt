package com.trustlyapps.drinkgame.diezSeg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.trustlyapps.drinkgame.R

class ReglasDiezSegs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reglas_diez_segs)

        val toolbar = findViewById<Toolbar>(R.id.tlRdiezSegs)
        val actionBar = supportActionBar
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
    }
}