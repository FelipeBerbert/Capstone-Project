package br.berbert.capstone.fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;
import br.berbert.capstone.adapters.PlacesAdapter;
import br.berbert.capstone.conn.PlacesSyncAdapter;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.place.PlaceCursor;

/**
 * Created by Felipe Berbert on 09/06/2016.
 * Fragment that lists places
 */
public class PlacesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "Capstone project";
    private static final int PLACES_LOADER = 0;

    private ProgressBar mPbLoading;
    private RecyclerView mRvPlacesList;
    private TextView mTvNoData;
    private LinearLayout mLlPermissionDenied;
    private Button mBtRetry;
    private PlacesAdapter mPlacesAdapter;
    //private GoogleApiClient mGoogleApiClient;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
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
                requestSync();
            }
        });
        mPbLoading = (ProgressBar) rootView.findViewById(R.id.pb_loading);
        mTvNoData = (TextView) rootView.findViewById(R.id.tv_no_data);

        mRvPlacesList.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? getResources().getInteger(R.integer.grid_header_column_spam) : 1;
            }
        });
        mRvPlacesList.setLayoutManager(layoutManager);

        mPlacesAdapter = new PlacesAdapter(getContext(), new PlacesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Place item, PlacesAdapter.PlacesViewHolder viewHolder) {
                ((Callback) getActivity()).onItemSelected(item, viewHolder, mUserLocation);
            }
        });

        mRvPlacesList.setAdapter(mPlacesAdapter);

        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals(Utilities.PREF_USER_LAT) && mPlacesAdapter != null) {
                    mPlacesAdapter.notifyDataSetChanged(); //If the user has a new location, the views should be updated
                    Log.d(TAG, "onSharedPreferenceChanged");
                }
            }
        };
        PreferenceManager.getDefaultSharedPreferences(getContext()).registerOnSharedPreferenceChangeListener(listener);

        return rootView;
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
    public void onResume() {
        super.onResume();
        requestSync();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(PLACES_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(getContext()).unregisterOnSharedPreferenceChangeListener(listener);
    }


    private void showActivateLocationDialog(){
        new AlertDialog.Builder(getContext())
                .setTitle("Location settings")
                .setMessage("This app requires the location setting to be activated.")
                .setPositiveButton(R.string.lb_settings, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent viewIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(viewIntent);
                    }
                })
                .setNegativeButton(R.string.lb_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog.cancel();
                    }
                })
                .show();
    }

    private void requestSync() {
        Log.d(TAG, "requestSync");
        if (Utilities.checkPermission(getContext())) {
            if (!Utilities.checkLocationStatus(getContext())){
                showActivateLocationDialog();
            }
            PlacesSyncAdapter.syncNow(getContext());
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
    }

    public void permissionGranted() {
        mLlPermissionDenied.setVisibility(View.GONE);
        requestSync();
    }

    public void permissionDenied() {
        mLlPermissionDenied.setVisibility(View.VISIBLE);
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
        mPbLoading.setVisibility(View.GONE);
        if (!data.moveToFirst())
            updateEmptyView();
    }

    /**
     * Warn the user that no data was found
     */
    private void updateEmptyView(){
        mTvNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mPlacesAdapter.swapCursor(null);
    }

    public interface Callback {
        void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh, Location userLocation);
    }
}
