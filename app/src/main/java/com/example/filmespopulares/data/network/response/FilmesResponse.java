package com.example.filmespopulares.data.network.response;

import com.squareup.moshi.Json;

public class FilmesResponse {

    @Json(name = "poster_path")
    private final String posterPath ;

    @Json(name = "original_title")
    private final String originalTitle ;


    public FilmesResponse(String posterPath, String originalTitle) {
        this.posterPath = posterPath;
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }
}
