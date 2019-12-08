package com.example.pokemonhttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Pokeadapter extends RecyclerView.Adapter<Pokeadapter.ViewHolder> {
    private ArrayList<Pokemon> pokeaaray;
    private Context c;
    private View.OnClickListener pokelistner;


    public Pokeadapter(ArrayList<Pokemon> ppokeaaray, Context c) {
        this.pokeaaray = ppokeaaray;
        this.c = c;
    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner)
    {
        pokelistner = itemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //xml file
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(pokeaaray.get(position).getImage()).into(holder.poke_img);
        holder.poke_name.setText(pokeaaray.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return pokeaaray.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poke_img;
        TextView poke_name;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            poke_img = itemView.findViewById(R.id.poke_image);
            poke_name = itemView.findViewById(R.id.poke_name);
            itemView.setTag(this);
            itemView.setOnClickListener(pokelistner);
        }

    }
}
