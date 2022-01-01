package com.example.filmespopulares.data.network;

import com.example.filmespopulares.data.network.response.FilmesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {
    @GET("movie/popular")
    Call<FilmesResult> chaveKey (@Query("api_key") String chaveApi);
}
