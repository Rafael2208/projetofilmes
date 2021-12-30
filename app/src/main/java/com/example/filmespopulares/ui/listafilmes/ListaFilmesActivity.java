package com.example.filmespopulares.ui.listafilmes;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmespopulares.R;

public class ListaFilmesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerFilmes = findViewById(R.id.recRecyclerview);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter();
    }
}
