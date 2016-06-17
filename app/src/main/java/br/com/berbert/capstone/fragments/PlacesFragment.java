package br.com.berbert.capstone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

import br.com.berbert.capstone.BuildConfig;
import br.com.berbert.capstone.R;
import br.com.berbert.capstone.adapters.PlacesAdapter;
import br.com.berbert.capstone.models.Place;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class PlacesFragment extends Fragment {

    RecyclerView mRvPlacesList;
    PlacesAdapter mPlacesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        mRvPlacesList = (RecyclerView) rootView.findViewById(R.id.rv_places_list);

        mRvPlacesList.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        mRvPlacesList.setLayoutManager(layoutManager);

        if (BuildConfig.DEBUG)
            createMocks();

        mRvPlacesList.setAdapter(mPlacesAdapter);

        return rootView;
    }

    public void selectFirstPosition(){
        ViewTreeObserver vto = mRvPlacesList.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(mPlacesAdapter.getItemCount() > 0)
                    mRvPlacesList.findViewHolderForAdapterPosition(0).itemView.performClick();
                mRvPlacesList.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }

    private void createMocks(){
        Place elevadorLacerda = new Place();
        elevadorLacerda.setName("Elevador lacerda");
        elevadorLacerda.setPicture(R.drawable.elevador_lacerda1);
        elevadorLacerda.setDistance(300);
        elevadorLacerda.setDescription(getString(R.string.huge_lorem_ipsum));

        Place pelourinho = new Place();
        pelourinho.setName("Pelourinho");
        pelourinho.setPicture(R.drawable.pelourinho);
        pelourinho.setDistance(900);
        pelourinho.setDescription(getString(R.string.huge_lorem_ipsum));

        Place mercado = new Place();
        mercado.setName("Mercado Modelo");
        mercado.setPicture(R.drawable.mercado_modelo);
        mercado.setDistance(700);
        mercado.setDescription(getString(R.string.huge_lorem_ipsum));

        Place senhorBonfim = new Place();
        senhorBonfim.setName("Senhor do bonfim");
        senhorBonfim.setPicture(R.drawable.igreja_bonfim);
        senhorBonfim.setDistance(1200);
        senhorBonfim.setDescription(getString(R.string.huge_lorem_ipsum));

        ArrayList<Place> placesList = new ArrayList<>();
        placesList.add(elevadorLacerda);
        placesList.add(pelourinho);
        placesList.add(mercado);
        placesList.add(senhorBonfim);
        mPlacesAdapter = new PlacesAdapter(getContext(), placesList, new PlacesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Place item, PlacesAdapter.PlacesViewHolder viewHolder) {
                ((Callback)getActivity()).onItemSelected(item, viewHolder);
            }
        });
    }

    public interface Callback {
        void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh);
    }
}
