package com.example.mywatchlist_201928011;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieResultAdapter extends RecyclerView.Adapter<MovieResultAdapter.ViewHolder>{
    private List<FeatureList> movieResultList;

    public MovieResultAdapter(List<FeatureList> movieResultList) {
        this.movieResultList = movieResultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_feature_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        FeatureList result = movieResultList.get(position);

        holder.title_textview.setText(result.getTitle());
        holder.year_textview.setText(result.getYear());
        holder.imdbID_textview.setText(result.getImdbID());
        holder.type_textview.setText(result.getType());
        holder.poster_textview.setText(result.getPoster());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return movieResultList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title_textview;
        private TextView year_textview;
        private TextView imdbID_textview;
        private TextView type_textview;
        private TextView poster_textview;

        public ViewHolder(View v) {
            super(v);

            title_textview = v.findViewById(R.id.title_textview);
            year_textview = v.findViewById(R.id.year_textview);
            imdbID_textview = v.findViewById(R.id.imdbID_textview);
            type_textview = v.findViewById(R.id.type_textview);
            poster_textview = v.findViewById(R.id.poster_textview);

        }
    }
}
