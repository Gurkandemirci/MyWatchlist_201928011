package com.example.mywatchlist_201928011;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("movie")
    @Expose
    private String movie;
    @SerializedName("result")
    @Expose
    private List<FeatureList> result = null;

    public MovieResult() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public List<FeatureList> getResult() {
        return result;
    }

    public void setResult(List<FeatureList> result) {
        this.result = result;
    }

}
