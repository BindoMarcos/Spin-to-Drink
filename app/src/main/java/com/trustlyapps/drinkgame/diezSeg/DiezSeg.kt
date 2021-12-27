package com.trustlyapps.drinkgame.diezSeg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.androchef.happytimer.countdowntimer.CircularCountDownView
import com.androchef.happytimer.countdowntimer.HappyTimer
import com.trustlyapps.drinkgame.R
import kotlin.random.Random

class DiezSeg : AppCompatActivity() {

    private var contenido: TextView? = null
    private var shots: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diez_seg)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

        juegos()

        val circularCountDownView: CircularCountDownView = findViewById(R.id.circularCountDownView)
        circularCountDownView.isTimerTextShown = true
        circularCountDownView.timerType = HappyTimer.Type.COUNT_DOWN
        circularCountDownView.timerTextFormat = CircularCountDownView.TextFormat.SECOND
        circularCountDownView.strokeThicknessForeground = 5f
        circularCountDownView.strokeThicknessBackground = 10f
        circularCountDownView.strokeColorBackground = ContextCompat.getColor(this, R.color.black)
        circularCountDownView.strokeColorForeground = ContextCompat.getColor(this, R.color.white)
        circularCountDownView.timerTextColor = ContextCompat.getColor(this, R.color.AppGreen)
        circularCountDownView.timerTextSize = 13f
        circularCountDownView.initTimer(10)

        circularCountDownView.setOnClickListener {
            circularCountDownView.startTimer()
        }

        val boton = findViewById<Button>(R.id.bReglas)
        boton.setOnClickListener{
            val intent = Intent(this, ReglasDiezSegs::class.java)
            startActivity(intent)
        }

    }

    private fun juegos() {
        contenido = findViewById(R.id.tvContenido)
        shots = findViewById(R.id.tvShots)

        val dificultad = listOf(1, 2, 3)
        val randomIndex = Random.nextInt(dificultad.size)
        val difRandom = dificultad[randomIndex].toString()
        shots?.text = difRandom

        when (difRandom) {
            "1" -> {
                val quienEsMasEasy = resources.getStringArray(R.array.DiezSegsEasy)
                val juegoRandom = quienEsMasEasy.random()
                contenido?.text = juegoRandom
            }
            "2" -> {
                val quienEsMasMedium = resources.getStringArray(R.array.DiezSegsMedium)
                val juegosRandom = quienEsMasMedium.random()
                contenido?.text = juegosRandom
            }
            else -> {
                val quienEsMasHard = resources.getStringArray(R.array.DiezSegsHard)
                val juegosRandom = quienEsMasHard.random()
                contenido?.text = juegosRandom
            }
        }
    }
}


