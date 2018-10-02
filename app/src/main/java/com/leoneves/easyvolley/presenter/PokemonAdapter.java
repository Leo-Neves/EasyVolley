package com.leoneves.easyvolley.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leoneves.easyvolley.MainActivity;
import com.leoneves.easyvolley.R;
import com.leoneves.easyvolley.model.Pokemon;

import java.util.List;



public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<Pokemon> pokemon;
    private MainActivity activity;

    public PokemonAdapter(MainActivity activity, List<Pokemon> pokemon){
        this.activity = activity;
        this.pokemon = pokemon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(activity.getLayoutInflater().inflate(R.layout.row_pokemon, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Pokemon pokemon = this.pokemon.get(i);
        holder.url.setText(pokemon.getUrl());
        holder.nome.setText(pokemon.getName());
        holder.numero.setText(String.valueOf("#"+(holder.getAdapterPosition()+1)));
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nome;
        public TextView numero;
        public TextView url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tvNomePokemon);
            numero = itemView.findViewById(R.id.tvNumeroPokemon);
            url = itemView.findViewById(R.id.tvUrlPokemon);
        }
    }
}
