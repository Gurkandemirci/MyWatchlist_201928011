package com.example.mywatchlist_201928011;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailedMovieActivity extends AppCompatActivity {

    Button addToWatchListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);

        addToWatchListButton = findViewById(R.id.addToWatchListButton);
        ArrayList<Integer> WatchList = new ArrayList<Integer>();

        addToWatchListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatchList.add(0);       //get ID of current movie
            }
        });

    }
}
