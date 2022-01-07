package com.example.filmespopulares.ui.listafilmes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmespopulares.R;
import com.example.filmespopulares.data.network.response.FilmesResponse;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

     private List<FilmesResponse> filmes;
     private List<FilmesResponse> exempleList;




    public ListaFilmesAdapter( List<FilmesResponse> filmes) {

        this.filmes = filmes;
        this.exempleList= new ArrayList<>(filmes);


    }


    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.textTituloFilme.setText(filmes.get(position).getOriginalTitle());
    }


    @Override
    public int getItemCount() {
        return filmes.size();
    }








    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.textTituloFilme);

        }

    }
}
