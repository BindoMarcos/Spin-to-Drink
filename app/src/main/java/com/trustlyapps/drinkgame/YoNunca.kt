package com.trustlyapps.drinkgame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class YoNunca : AppCompatActivity() {

    var contenido: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.yo_nunca)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

        val boton = findViewById<Button>(R.id.bReglas)

        juegos()
    }

    private fun juegos() {
        contenido = findViewById(R.id.tvContenido)
        val yoNuncaJuegos = resources.getStringArray(R.array.yoNuncaJuegos)
        val juegoRandom = yoNuncaJuegos.random()

        contenido?.text = juegoRandom
    }
}

