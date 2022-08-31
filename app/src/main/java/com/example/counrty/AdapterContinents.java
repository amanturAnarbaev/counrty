package com.example.counrty;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterContinents extends RecyclerView.Adapter<AdapterContinents.ContinentViewHolder> {
    private ArrayList<Continents> continent_list_adapter;
    private OnItemClickListener listener;

    public AdapterContinents(ArrayList<Continents> continent_list_adapter, OnItemClickListener listener) {
        this.continent_list_adapter = continent_list_adapter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continents, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(continent_list_adapter.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return continent_list_adapter.size();
    }

    public Continents getContinent(int position) {
        return continent_list_adapter.get(position);
    }

    static class ContinentViewHolder extends RecyclerView.ViewHolder {
        private TextView tx_continent;
        private ImageView continent_flag;

        public ContinentViewHolder(@NonNull View itemView) {
            super(itemView);
            tx_continent = itemView.findViewById(R.id.continent_item_tx);
        }

        public void bind(Continents continent) {
            tx_continent.setText(continent.getName());
            continent_flag = itemView.findViewById(R.id.flag_of_continent_item);
            Glide.with(continent_flag).load(continent.getFlag()).into(continent_flag);

        }
    }
}
