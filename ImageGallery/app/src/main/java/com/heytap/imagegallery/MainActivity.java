package com.heytap.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        });


    }
}