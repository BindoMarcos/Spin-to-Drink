package com.trustlyapps.drinkgame.quienEsMas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.trustlyapps.drinkgame.R
import kotlin.random.Random

class QuienEsMas : AppCompatActivity() {
    var contenido:TextView? = null
    var shots:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quien_es_mas)

        val toolbar = findViewById<Toolbar>(R.id.tlquienEs)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

        val boton = findViewById<Button>(R.id.bReglas)
        boton.setOnClickListener{
            val intent= Intent(this, ReglasQuienEsMas::class.java)
            startActivity(intent)
        }

        juegos()
    }

    private fun juegos(){
        contenido = findViewById(R.id.tvContenido)
        shots = findViewById(R.id.tvShots)

        val dificultad = listOf(1,2,3)
        val randomIndex = Random.nextInt(dificultad.size)
        val difRandom = dificultad[randomIndex].toString()
        shots?.text = difRandom

        if(difRandom == "1"){
            val quienEsMasEasy = resources.getStringArray(R.array.quienEsMasProbableEasy)
            val juegoRandom = quienEsMasEasy.random()
            contenido?.text = juegoRandom
        }else if(difRandom == "2") {
            val quienEsMasMedium = resources.getStringArray(R.array.quienEsMasProbableMedium)
            val juegosRandom = quienEsMasMedium.random()
            contenido?.text == juegosRandom
        }else{
            val quienEsMasHard= resources.getStringArray(R.array.quienEsMasProbableHard)
            val juegosRandom = quienEsMasHard.random()
            contenido?.text = juegosRandom
        }
    }
}