package com.trustlyapps.drinkgame

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.WheelItem
import com.trustlyapps.drinkgame.diezSeg.DiezSeg
import com.trustlyapps.drinkgame.quienEsMas.QuienEsMas
import com.trustlyapps.drinkgame.yoNunca.YoNunca
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {

    private var spin: ImageButton? = null
    private var wheelItemsArray: MutableList<WheelItem> = ArrayList()

    private var point: String? = null

    private var luckywheel: LuckyWheel? = null

    private var animacion: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.GameToolbar)
        setSupportActionBar(toolbar)


        generarItems()
        luckywheel = findViewById(R.id.luckywheel)

        luckywheel?.addWheelItems(wheelItemsArray)

        spin = findViewById(R.id.bSpin)

        spin?.setOnClickListener {
            spinRoulette()
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
                    "popuptext", "El Actual HOST tendra que heredar su puesto al jugador que desee"
                )
                intent.putExtra("popupbutton", "OK")
                intent.putExtra("darkstatusbar", false)
                startActivity(intent)
            }
            if (point == "9") {
                spinRoulette()
            }
        }
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

   /* private fun changeLanguage() {
        var languageToLoad: String = ""

        if(Locale.getDefault().language.contains("es")){
            languageToLoad = "en"
        }else if (Locale.getDefault().language.contains("en")){
            languageToLoad = "es"
        }

        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        this.resources
            .updateConfiguration(config, this.resources.displayMetrics)

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

        Toast.makeText(this, Locale.getDefault().language, Toast.LENGTH_SHORT).show()
    }*/

    private fun rotacion() {
        animacion = AnimationUtils.loadAnimation(this, R.anim.anim_boton)
        val rnds = (1..12).random()
        luckywheel?.rotateWheelTo(rnds)
        point = rnds.toString()
        spin?.startAnimation(animacion)
    }

    private fun buttonDelay() {
        spin?.isEnabled = false

        val buttonTimer = Timer()
        buttonTimer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread { spin?.isEnabled = true }
            }
        }, 9000)
    }

    private fun spinRoulette() {
        buttonDelay()
        rotacion()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.iChangeLang -> {
                Toast.makeText(this, "Nuevos idiomas \n vendran pronto", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return onOptionsItemSelected(item)
            }
        }
    }

}


