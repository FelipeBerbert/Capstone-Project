package br.com.berbert.capstone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.berbert.capstone.BuildConfig;
import br.com.berbert.capstone.R;
import br.com.berbert.capstone.adapters.PlacesAdapter;
import br.com.berbert.capstone.models.Place;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class PlacesFragment extends Fragment {

    RecyclerView rvPlacesList;
    PlacesAdapter placesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        rvPlacesList = (RecyclerView) rootView.findViewById(R.id.rv_places_list);

        rvPlacesList.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        rvPlacesList.setLayoutManager(layoutManager);

        if (BuildConfig.DEBUG)
            createMocks();

        rvPlacesList.setAdapter(placesAdapter);

        return rootView;
    }

    private void createMocks(){
        Place elevadorLacerda = new Place();
        elevadorLacerda.setName("Elevador lacerda");
        elevadorLacerda.setPicture(R.drawable.elevador_lacerda1);
        elevadorLacerda.setDistance(300);
        ArrayList<Place> placesList = new ArrayList<>();
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesAdapter = new PlacesAdapter(getContext(), placesList);
    }
}
