package com.example.mywatchlist_201928011;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends Activity {

    EditText movieNameInput;
    Button findMovieButton;
    Button showWatchListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieNameInput = findViewById(R.id.movieNameInput);
        findMovieButton = findViewById(R.id.findMovieButton);
        showWatchListButton = findViewById(R.id.showWatchListButton);

        findMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateMovieListActivity();
            }
        });

        showWatchListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addToWatchList(movieNameInput.getText().toString());
                navigateWatchListActivity();
            }
        });






    }


    private void navigateMovieListActivity(){
        Intent movieListIntent = new Intent(getApplicationContext(),MovieListActivity.class);
        movieListIntent.putExtra("movieName", movieNameInput.getText().toString());
        startActivity(movieListIntent);
    }

    private void addToWatchList(String imdbID){
        String CONST_DATA = "WATCH_LIST";
        SharedPreferences preferences = this.getSharedPreferences(CONST_DATA, getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONST_DATA,String.valueOf(imdbID));
        editor.apply();

    }

    private String getMovieFromWatchList(){
        String result;
        String CONST_DATA = "WATCH_LIST";
        SharedPreferences preferences = this.getSharedPreferences(CONST_DATA, getApplicationContext().MODE_PRIVATE);
        result = preferences.getString(CONST_DATA, "");
        return result;
    }


    private void navigateWatchListActivity(){
        Intent watchListIntent = new Intent(MainActivity.this,WatchListActivity.class);
        startActivity(watchListIntent);
    }

}