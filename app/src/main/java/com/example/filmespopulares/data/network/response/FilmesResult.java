package com.example.filmespopulares.data.network.response;

import java.util.List;

public class FilmesResult {

    private final List<FilmesResponse> results; // results do responses

    public FilmesResult(List<FilmesResponse> results) {
        this.results = results;
    }

    public List<FilmesResponse> getResults() {
        return results;
    }
}
