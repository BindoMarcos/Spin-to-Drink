package com.trustlyapps.drinkgame

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.luckywheel.LuckyWheel
import com.bluehomestudio.luckywheel.WheelItem
import kotlin.random.Random.Default.nextInt

//var wheelItems: MutableList<WheelItem> = ArrayList()

class MainActivity : AppCompatActivity() {

    var luckywheel: LuckyWheel? = null
    var spin: Button? = null
    var wheelItems: MutableList<WheelItem> = ArrayList()
    var count = 0

    val diezSeg = R.drawable.stopwatch
    val yoNunca = R.drawable.hand_yo_nunca
    val quienEsMas = R.drawable.question_solid
    val host = R.drawable.host
    val reload = R.drawable.reload
    val shot = R.drawable.glass_shot_solid


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generarItems()

        luckywheel = findViewById(R.id.luckywheel)
        luckywheel?.addWheelItems(wheelItems)
        spin = findViewById(R.id.bSpin)

        spin?.setOnClickListener {
            count += 1
            val random = random(11..200)
            luckywheel?.rotateWheelTo(random)
        }

        luckywheel?.setLuckyWheelReachTheTarget {}
    }

    fun random(range: IntRange): Int {
        return range.first + nextInt(range.last - range.first)
    }

    private fun generarItems() {
        wheelItems

        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, shot)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, yoNunca)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, quienEsMas)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, diezSeg)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, host)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, yoNunca)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, quienEsMas)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, diezSeg)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, reload)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, yoNunca)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, quienEsMas)
            )
        )
        wheelItems.add(
            WheelItem(
                Color.BLACK,
                BitmapFactory.decodeResource(resources, diezSeg)
            )
        )
    }

    private fun reachTarget() {

    }
}

