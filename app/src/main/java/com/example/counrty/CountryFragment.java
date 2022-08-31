package com.example.counrty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CountryFragment extends Fragment {
    private RecyclerView recyclerView_country;
    private ArrayList<Country> country_list;
    private TextView tx_country_item;
    private ImageView flag_country;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tx_country_item = view.findViewById(R.id.country_item_tx);
        flag_country = view.findViewById(R.id.flag_of_country_item);
        recyclerView_country = view.findViewById(R.id.countreRcycleView);
        loadData();
        AdapterForCountry adapterForCountry = new AdapterForCountry(country_list);
        recyclerView_country.setAdapter(adapterForCountry);


    }

    private void loadData() {
        country_list = new ArrayList<>();
        country_list.add(new Country("aafewf", ""));
    }
}