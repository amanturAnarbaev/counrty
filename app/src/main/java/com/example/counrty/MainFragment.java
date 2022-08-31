package com.example.counrty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class MainFragment extends Fragment implements OnItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Continents> continents;
    private AdapterContinents adapterContinents;
    public static String KEY_FOR_BUNDLE = "key continent";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.continentRecycle_xml);
        loadData();

        adapterContinents = new AdapterContinents(continents, this);
        recyclerView.setAdapter(adapterContinents);
    }

    @Override
    public void onItemClick(int position) {
        Continents continents = adapterContinents.getContinent(position);

//
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new CountryFragment()).addToBackStack(null).commit();
    }

    private void loadData() {
        continents = new ArrayList<>();
        continents.add(new Continents("Asia", "https://fvmstatic.s3.amazonaws.com/maps/m/WRLD-AS-01-0003.png"));
        continents.add(new Continents("Europe", "https://as1.ftcdn.net/v2/jpg/04/35/76/42/1000_F_435764240_GqAh0S6paR9x6mgrhufzPTo8qHzBynQ5.jpg"));
        continents.add(new Continents("Africa", "https://fvmstatic.s3.amazonaws.com/maps/m/WRLD-AF-01-0003.png"));
        continents.add(new Continents("North America", "https://thumbs.dreamstime.com/b/vector-file-north-america-map-continent-entirely-northern-hemisphere-all-western-hemisphere-136349461.jpg"));
        continents.add(new Continents("South America", "https://media.istockphoto.com/vectors/vector-illustration-with-simplified-map-of-south-america-continent-vector-id1158614884"));
        continents.add(new Continents("Australia", "https://previews.123rf.com/images/yevgenijd/yevgenijd1707/yevgenijd170700056/81812015-australia-and-oceania-map-monochrome-australia-icon-vector.jpg"));
    }


}