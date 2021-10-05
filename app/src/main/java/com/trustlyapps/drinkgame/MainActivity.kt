package com.trustlyapps.drinkgame

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.WheelItem


class MainActivity : AppCompatActivity() {

    var spin: ImageButton? = null
    var wheelItemsArray: MutableList<WheelItem> = ArrayList()
    var count = 0

    var point: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animacion: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_boton)
        generarItems()

        val luckywheel = findViewById<LuckyWheel>(R.id.luckywheel)
        luckywheel.addWheelItems(wheelItemsArray)
        spin = findViewById(R.id.bSpin)


        spin?.setOnClickListener {
            count += 1
            val rnds = (1..12).random()
            point = rnds.toString()
            luckywheel?.rotateWheelTo(rnds)
            spin?.startAnimation(animacion)
        }

        luckywheel?.setLuckyWheelReachTheTarget {
            val rnds = (1..12).random()
            if (point == "2" || point == "6" || point == "10") {
                Toast.makeText(this, "Yo nunca", Toast.LENGTH_SHORT).show()
            }
            if (point == "3" || point == "7" || point == "11") {
                Toast.makeText(this, "Quien es mas", Toast.LENGTH_SHORT).show()
            }
            if(point == "4" || point == "8" || point == "12" ){
                Toast.makeText(this, "10 Seg", Toast.LENGTH_SHORT).show()
            }
            if(point == "1"){
                Toast.makeText(this, "shot", Toast.LENGTH_SHORT).show()
            }
            if (point == "5"){
                Toast.makeText(this, "host", Toast.LENGTH_SHORT).show()
            }
            if(point == "9"){
                luckywheel.rotateWheelTo(rnds)
            }
            }
    }
    /* fun random(range: IntRange): Int {
         return range.first + nextInt(range.last - range.first)
     }*/

    fun generarItems() {
        wheelItemsArray

        val diezSeg = WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.stopwatch))

        val yoNunca =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.hand_yo_nunca))

        val quienesmas =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.question_solid))

        val host =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.host))

        val reload =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.reload))

        val shot =
            WheelItem(Color.BLACK, BitmapFactory.decodeResource(resources, R.drawable.glass_shot_solid))

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

