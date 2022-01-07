package com.example.filmespopulares.ui.listafilmes;



import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmespopulares.R;
import com.example.filmespopulares.data.network.ApiService;
import com.example.filmespopulares.data.network.response.FilmesResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        Api();
    }



    private void Api(){

        RecyclerView recyclerFilmes = findViewById(R.id.recRecyclerview);


        ApiService.getInstance()
                .chaveKey("e3636e6dc5765fd2712e009a260de153")
                .enqueue(new Callback<FilmesResult>() {

                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {


                        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListaFilmesActivity.this);
                        recyclerFilmes.setLayoutManager(linearLayoutManager);
                        recyclerFilmes.setAdapter(new ListaFilmesAdapter(response.body().getResults()));
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {

                    }
                });

    }

}
