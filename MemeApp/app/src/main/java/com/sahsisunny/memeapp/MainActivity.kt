package com.sahsisunny.memeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val previousButton = findViewById<Button>(R.id.previous_button)
        val nextButton = findViewById<Button>(R.id.next_button)
        val shareButton = findViewById<Button>(R.id.share_button)
        val imageContainer = findViewById<ImageView>(R.id.meme_image)

        val apiUrl: String = "https://meme-api.com/gimme"
        var imageUrl: String = ""
        var previousImageUrl: String = ""

        fun loadMeme() {
            val jsonObjectRequest =
                JsonObjectRequest(
                    apiUrl, null,
                    { response ->
                        imageUrl = response.getString("url")
                        Glide.with(this).load(imageUrl)
                            .into(imageContainer)
                    },
                    {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    })

            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
        }
        loadMeme()

        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, checkout this cool meme $imageUrl")
            val chooser = Intent.createChooser(intent, "Share this meme using...")
            startActivity(chooser)
        }
        previousButton.setOnClickListener {
            Toast.makeText(this, "Loading previous meme", Toast.LENGTH_SHORT).show()
            Glide.with(this).load(previousImageUrl).into(imageContainer)
        }
        nextButton.setOnClickListener {
            loadMeme()
            Toast.makeText(this, "Loading new meme", Toast.LENGTH_SHORT).show()
            previousImageUrl = imageUrl
        }
    }
}

