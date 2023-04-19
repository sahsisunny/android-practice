package com.sahsisunny.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val diceImage: ImageView = findViewById(R.id.dice_image)

        fun animateDice() {
            diceImage.animate().apply {
                duration = 1000
                rotationXBy(360f)
            }.start()
        }

        fun rollDice() {
            val randomValue = Random.nextInt(6) + 1
            Toast.makeText(this, "Your dice rolled $randomValue", Toast.LENGTH_SHORT).show()
            val drawableResource = when (randomValue) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
        }
        rollButton.setOnClickListener {
            animateDice()
            rollDice()
        }
    }
}