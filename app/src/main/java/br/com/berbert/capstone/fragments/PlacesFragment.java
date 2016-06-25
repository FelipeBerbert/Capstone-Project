package br.com.berbert.capstone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import br.com.berbert.capstone.BuildConfig;
import br.com.berbert.capstone.R;
import br.com.berbert.capstone.adapters.PlacesAdapter;
import br.com.berbert.capstone.conn.GsonRequest;
import br.com.berbert.capstone.conn.VolleyConnection;
import br.com.berbert.capstone.models.NearbySearchResponse;
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
                return position == 0 ? getResources().getInteger(R.integer.grid_header_column_spam) : 1;
            }
        });
        mRvPlacesList.setLayoutManager(layoutManager);

//        if (BuildConfig.DEBUG)
//            createMocks();


        requestPlaces();


        return rootView;
    }

    private void requestPlaces() {

        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        sb.append("location=" + -13.008348 + "," + -38.492842);
        sb.append("&radius=3000");
        sb.append("&types=" + "amusement_park|aquarium|art_gallery|campground|museum|park|zoo");
        sb.append("&key=" + BuildConfig.PLACES_API_KEY);

        String url = sb.toString();

        GsonRequest<NearbySearchResponse> request = new GsonRequest<>(url, NearbySearchResponse.class, null, new Response.Listener<NearbySearchResponse>() {

            @Override
            public void onResponse(NearbySearchResponse response) {
                if (BuildConfig.DEBUG)
                    for (Place place : response.getResults()) {
                        Log.d("CAPSTONE PROJECT", "Response: " + place.getName());
                        for (String type : place.getTypes())
                            Log.d("CAPSTONE PROJECT", "Type: " + type);  // TODO ONLY FOR DEBUG, DELETE THIS
                    }

                mPlacesAdapter = new PlacesAdapter(getContext(), new ArrayList<>(response.getResults()), new PlacesAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Place item, PlacesAdapter.PlacesViewHolder viewHolder) {
                        ((Callback) getActivity()).onItemSelected(item, viewHolder);
                    }
                });
                mRvPlacesList.setAdapter(mPlacesAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("CAPSTONE PROJECT", "Response: " + error.getMessage());
            }
        });


        VolleyConnection.getInstance(getContext()).addToRequestQueue(request);
    }

    public void selectFirstPosition() {
        ViewTreeObserver vto = mRvPlacesList.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (mPlacesAdapter.getItemCount() > 0)
                    mRvPlacesList.findViewHolderForAdapterPosition(0).itemView.performClick();
                mRvPlacesList.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }

    public interface Callback {
        void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh);
    }
}
