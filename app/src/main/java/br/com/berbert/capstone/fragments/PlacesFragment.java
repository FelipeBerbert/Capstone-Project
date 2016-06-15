package br.com.berbert.capstone.fragments;

import android.content.Intent;
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
import br.com.berbert.capstone.DetailActivity;
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
        elevadorLacerda.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce euismod metus nunc, in tincidunt elit lacinia at. Vestibulum tincidunt quam a augue placerat, eget viverra odio placerat. Praesent vestibulum dictum tempor. Nunc neque nulla, laoreet id ex eu, congue condimentum eros. Nulla sit amet quam vehicula, faucibus nisi vitae, euismod risus. Mauris non tristique mauris. Fusce nec tristique libero, et malesuada tortor. Sed ut nisl nec ex congue elementum egestas non ligula. Nulla hendrerit, nibh eu lobortis euismod, ante dolor lacinia massa, in maximus ipsum nibh vitae sem. In vel mauris tincidunt, congue ex a, laoreet dolor. Donec vel lacus ut nunc dapibus aliquet. ");
        ArrayList<Place> placesList = new ArrayList<>();
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesList.add(elevadorLacerda);
        placesAdapter = new PlacesAdapter(getContext(), placesList, new PlacesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Place item) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.PARAM_PLACE, item);
                startActivity(intent);
            }
        });
    }
}
