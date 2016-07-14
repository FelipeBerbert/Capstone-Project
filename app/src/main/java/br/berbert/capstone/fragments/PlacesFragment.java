package br.berbert.capstone.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import br.berbert.capstone.BuildConfig;
import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;
import br.berbert.capstone.adapters.PlacesAdapter;
import br.berbert.capstone.conn.GsonRequest;
import br.berbert.capstone.conn.VolleyConnection;
import br.berbert.capstone.models.NearbySearchResponse;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.place.PlaceCursor;

/**
 * Created by Felipe Berbert on 09/06/2016.
 */
public class PlacesFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LoaderManager.LoaderCallbacks<Cursor> {
    private final String TAG = "Capstone project";

    RecyclerView mRvPlacesList;
    LinearLayout mLlPermissionDenied;
    Button mBtRetry;
    PlacesAdapter mPlacesAdapter;
    GoogleApiClient mGoogleApiClient;
    public Location mUserLocation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        mRvPlacesList = (RecyclerView) rootView.findViewById(R.id.rv_places_list);
        mLlPermissionDenied = (LinearLayout) rootView.findViewById(R.id.ll_permission_denied);
        mBtRetry = (Button) rootView.findViewById(R.id.bt_retry);
        mBtRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLocation();
            }
        });

        mRvPlacesList.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? getResources().getInteger(R.integer.grid_header_column_spam) : 1;
            }
        });
        mRvPlacesList.setLayoutManager(layoutManager);


        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        return rootView;
    }

    private void requestPlaces(Location location) {

        Utilities.buildPlacesRequest(getContext(), location, new Response.Listener<NearbySearchResponse>() {

            @Override
            public void onResponse(NearbySearchResponse response) {
                if (BuildConfig.DEBUG)
                    for (Place place : response.getResults()) {
                        Log.d(TAG, "Response: " + place.getName());
                        //for (String type : place.getTypes())
                          //  Log.d(TAG, "Type: " + type);  // TODO ONLY FOR DEBUG, DELETE THIS
                    }

                mPlacesAdapter = new PlacesAdapter(getContext(), mUserLocation, new PlacesAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Place item, PlacesAdapter.PlacesViewHolder viewHolder) {
                        ((Callback) getActivity()).onItemSelected(item, viewHolder, mUserLocation);
                    }
                });
                mRvPlacesList.setAdapter(mPlacesAdapter);
            }
        },  new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("CAPSTONE PROJECT", "Response: " + error.getMessage());
            }
        });
    }

    private List<Place> filterResults(List<Place> places) {
        List<Place> filteredPlaces = new ArrayList<>();
        for (Place place : places) {
            if (place.getPhotos().size() == 0)  //For now, I dont see much sense in having places without pictures in the app
                filteredPlaces.add(place);
        }
        places.removeAll(filteredPlaces);
        return places;
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


    @Override
    public void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    public void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        Log.d(TAG,"Google API connected");
        requestLocation();
    }

    private void requestLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mUserLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mUserLocation != null) {
                requestPlaces(mUserLocation);
            } else {
                Toast.makeText(getContext(), "Could not get location", Toast.LENGTH_SHORT).show();
                //todo only for debugging on emulator
                mUserLocation = new Location("mock");
                mUserLocation.setLatitude(-23.54954954954955);
                mUserLocation.setLongitude(-46.64128086138674);
                requestPlaces(mUserLocation);
            }
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        }
    }

    public void permissionGranted(){
        mLlPermissionDenied.setVisibility(View.GONE);
        requestLocation();
    }
    public void permissionDenied(){
        mLlPermissionDenied.setVisibility(View.VISIBLE);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("GoogleApi Error"," "+connectionResult.getErrorMessage());
        //todo message
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                PlaceColumns.CONTENT_URI,
                PlaceColumns.ALL_COLUMNS,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mPlacesAdapter.swapCursor(new PlaceCursor(data));
        //todo updateEmptyView();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mPlacesAdapter.swapCursor(null);
    }

    public interface Callback {
        void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh, Location userLocation);
    }
}
