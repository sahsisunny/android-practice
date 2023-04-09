package com.heytap.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Objects;

public class FullScreenActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        imageView = findViewById(R.id.imageView);

        Objects.requireNonNull(getSupportActionBar()).hide();
        getSupportActionBar().setTitle("Full Screen Image");

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapter fullScreenImageAdapter = new ImageAdapter(this);

        imageView.setImageResource(fullScreenImageAdapter.imageArray[position]);

    }
}