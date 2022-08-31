package com.example.counrty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterForCountry extends RecyclerView.Adapter<AdapterForCountry.CountryViewHolder> {
    private ArrayList<Country> country_list;

    public AdapterForCountry(ArrayList<Country> country_list) {
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_counnty,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
holder.bind(country_list.get(position));
    }

    @Override
    public int getItemCount() {
        return country_list.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView tx_country_item;
        private ImageView flag_country;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tx_country_item=itemView.findViewById(R.id.country_item_tx);
        }
        public void bind(Country country){
            tx_country_item.setText(country.getName());
            flag_country=itemView.findViewById(R.id.flag_of_country_item);
            Glide.with(flag_country).load(country.getFlag()).into(flag_country);
        }
    }
}
