package com.trustlyapps.drinkgame.yoNunca

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.trustlyapps.drinkgame.R
import kotlin.random.Random

class YoNunca : AppCompatActivity() {

    var contenido: TextView? = null
    var shots: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.yo_nunca)

        val toolbar = findViewById<Toolbar>(R.id.tlyoNunca)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

        val boton = findViewById<Button>(R.id.bReglas)
        boton.setOnClickListener {
            val intent= Intent(this, ReglasYoNunca::class.java)
            startActivity(intent)
        }

        juegos()
    }

    private fun juegos() {
        contenido = findViewById(R.id.tvContenido)
        shots = findViewById(R.id.tvShots)

        val dificultad = listOf(1, 2, 3)
        val randomIndex = Random.nextInt(dificultad.size)
        val difRandom = dificultad[randomIndex].toString()
        shots?.text = difRandom

        if (difRandom == "1"){
            val yoNuncaJuegosBasic = resources.getStringArray(R.array.yoNuncaEasy)
            val juegoRandom = yoNuncaJuegosBasic.random()
            contenido?.text = juegoRandom
        }else if(difRandom == "2"){
            val yoNuncaJuegosMedium = resources.getStringArray(R.array.yoNuncaMedium)
            val juegoRandom = yoNuncaJuegosMedium.random()
            contenido?.text = juegoRandom
        }else{
            val yoNuncaJuegosHard= resources.getStringArray(R.array.yoNuncaHard)
            val juegoRandom = yoNuncaJuegosHard.random()
            contenido?.text = juegoRandom
        }
    }
}

