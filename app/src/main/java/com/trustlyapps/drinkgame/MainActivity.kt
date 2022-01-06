package com.trustlyapps.drinkgame

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.WheelItem
import com.trustlyapps.drinkgame.diezSeg.DiezSeg
import com.trustlyapps.drinkgame.quienEsMas.QuienEsMas
import com.trustlyapps.drinkgame.yoNunca.YoNunca

class MainActivity : AppCompatActivity() {

    private var spin: ImageButton? = null
    private var wheelItemsArray: MutableList<WheelItem> = ArrayList()

    private var point: String? = null

    private var luckywheel: LuckyWheel? = null

    private var animacion: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generarItems()
        luckywheel = findViewById(R.id.luckywheel)

        luckywheel?.addWheelItems(wheelItemsArray)
        spin = findViewById(R.id.bSpin)

        spin?.setOnClickListener {
            rotacion()
        }

        val bReglas: Button= findViewById(R.id.bReglasMain)
        bReglas.setOnClickListener{
            val intent = Intent(this, Reglas::class.java)
            startActivity(intent)
        }

        luckywheel?.setLuckyWheelReachTheTarget {
            if (point == "2" || point == "6" || point == "10") {
                val intent = Intent(this, YoNunca::class.java)
                startActivity(intent)
            }
            if (point == "3" || point == "7" || point == "11") {
                val intent = Intent(this, QuienEsMas::class.java)
                startActivity(intent)
            }
            if (point == "4" || point == "8" || point == "12") {
                val intent = Intent(this, DiezSeg::class.java)
                startActivity(intent)
            }
            if (point == "1") {
                val intent = Intent(this, PopUpWindow::class.java)
                intent.putExtra("popuptitle", "SHOT")
                intent.putExtra(
                    "popuptext",
                    "Todos los jugadores (incluyendo el host), beben un trago"
                )
                intent.putExtra("popupbutton", "OK")
                intent.putExtra("darkstatusbar", false)
                startActivity(intent)
            }
            if (point == "5") {
                val intent = Intent(this, PopUpWindow::class.java)
                intent.putExtra("popuptitle", "CAMBIO DE HOST")
                intent.putExtra(
                    "popuptext",
                    "El Actual HOST tendra que heredar su puesto al jugador que desee"
                )
                intent.putExtra("popupbutton", "OK")
                intent.putExtra("darkstatusbar", false)
                startActivity(intent)
            }
            if (point == "9") {
                rotacion()
                Toast.makeText(this, "Vuelve a girar la ruleta", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun rotacion() {
        animacion = AnimationUtils.loadAnimation(this, R.anim.anim_boton)
        val rnds = (1..12).random()
        luckywheel?.rotateWheelTo(rnds)
        point =  rnds.toString()
        spin?.startAnimation(animacion)
    }

    private fun generarItems() {
        wheelItemsArray

        val diezSeg =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.stopwatch))

        val yoNunca =
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, R.drawable.hand_yo_nunca)
            )

        val quienesmas =
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, R.drawable.question_solid)
            )

        val host =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.host))

        val reload =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.reload))

        val shot =
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, R.drawable.glass_shot_solid)
            )

        wheelItemsArray.add(shot)

        wheelItemsArray.add(yoNunca)
        wheelItemsArray.add(quienesmas)
        wheelItemsArray.add(diezSeg)

        wheelItemsArray.add(host)

        wheelItemsArray.add(yoNunca)
        wheelItemsArray.add(quienesmas)
        wheelItemsArray.add(diezSeg)

        wheelItemsArray.add(reload)

        wheelItemsArray.add(yoNunca)
        wheelItemsArray.add(quienesmas)
        wheelItemsArray.add(diezSeg)
    }


    }


