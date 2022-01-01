package com.example.filmespopulares.ui.listafilmes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.filmespopulares.R;
import com.example.filmespopulares.data.network.response.FilmesResponse;
import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> implements Filterable {

    private List<FilmesResponse> filmes;
    private List<FilmesResponse> exempleList;


    public ListaFilmesAdapter(List<FilmesResponse> filmes){

        this.filmes = filmes;
        exempleList = new ArrayList<>(filmes);
    }


    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent,false);
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

    // filtrar

    @Override
    public Filter getFilter() {
        return exempleFilter;
    }

    private Filter exempleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FilmesResponse> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(exempleList);
            } else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (FilmesResponse resp : exempleList){
                    if(resp.getOriginalTitle().toLowerCase().contains(filterPattern)){  // getOriginalTitle obs
                        filteredList.add(resp);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filmes.clear();
            filmes.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private TextView textTituloFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.textTituloFilme);

        }

    }
}
