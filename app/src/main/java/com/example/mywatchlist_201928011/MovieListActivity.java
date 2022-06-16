package com.example.mywatchlist_201928011;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class MovieListActivity extends AppCompatActivity {

    String movieName ;
    private RecyclerView movie_list_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        //weather_list_recyclerview = findViewById(R.id.weather_list_recyclerview);
        movie_list_recyclerview = findViewById(R.id.movie_list_recyclerview);
        movieName = "";
        Bundle bundle = getIntent().getExtras();


        if(bundle != null)
        {
            movieName = bundle.getString("movieName");
        }

        getMoviesFromNetwork();

    }

    private void getMoviesFromNetwork()
    {

        Response response;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.collectapi.com/imdb/imdbSearchByName?query=" + movieName)
                .method("GET", null)
                .addHeader("authorization", "apikey 0inFTf6FetNlEas2j8dcfz:1Tu4s6B7E8ktkyGfI4aNNk")
                .addHeader("content-type", "application/json")
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("Error");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful())
                {
                    final String responseBody = response.body().string();
                    MovieResult movieResult = new Gson().fromJson(responseBody,MovieResult.class);

                    
                    MovieListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setAdapterRecyclerView(movieResult.getResult());
                        }
                    });



                }
            }
        });
    }

    private void setAdapterRecyclerView(List<FeatureList> resultList)
    {
        // adapter
        MovieResultAdapter adapter = new MovieResultAdapter(resultList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        movie_list_recyclerview.setLayoutManager(mLayoutManager);
        movie_list_recyclerview.setAdapter(adapter);
    }
}
