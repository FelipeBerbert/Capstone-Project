package br.berbert.capstone.conn;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncRequest;
import android.content.SyncResult;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;
import br.berbert.capstone.models.NearbySearchResponse;
import br.berbert.capstone.models.Photo;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.photo.PhotoContentValues;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.place.PlaceContentValues;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 27/07/2016.
 */
public class PlacesSyncAdapter extends AbstractThreadedSyncAdapter implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "PlacesSyncAdapter";

    ContentResolver mContentResolver;
    GoogleApiClient mGoogleApiClient;

    public PlacesSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        Log.d(TAG, "Constructor");
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.d(TAG, "onPerformSync");
        mContentResolver = getContext().getContentResolver();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();
        } else
            requestPlaces();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "onConnected");
        requestPlaces();
    }

    private void requestPlaces() {
        Log.d(TAG, "requestPlaces");
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission granted");
            Location userLocation;
            userLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            if (userLocation != null) {
                Utilities.saveUserLocation(getContext(), userLocation);
                final Location location = Utilities.loadUserLocation(getContext());
                Utilities.buildPlacesRequest(getContext(), location, new Response.Listener<NearbySearchResponse>() {

                    @Override
                    public void onResponse(NearbySearchResponse response) {
                        try {
                            for (Place place : response.getResults()) {
                                Log.d(TAG, "Response: " + place.getName());
                                PlaceContentValues placeValues = new PlaceContentValues();
                                placeValues.putPlaceValues(place, location);
                                Uri newRow = getContext().getContentResolver().insert(PlaceColumns.CONTENT_URI, placeValues.values());
                                if (newRow != null && place.getPhotos().size() > 0) {
                                    long newPlaceId = Long.valueOf(newRow.toString().substring(newRow.toString().lastIndexOf("/") + 1));
                                    Photo mainPhoto = place.getPhotos().get(0);
                                    PhotoContentValues photoValues = new PhotoContentValues();
                                    photoValues.putPhotoValues(mainPhoto, newPlaceId);
                                    getContext().getContentResolver().insert(PhotoColumns.CONTENT_URI, photoValues.values());
                                }
                            }

                            //todo delete old data

                        } catch (Exception e) {
                            Log.e(TAG, e.getMessage(), e);
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Response: " + error.getMessage());
                    }
                });
            } else
                Log.d(TAG, "userLocation null");

        } else {
            // This will help me see if the user refused the location permission
            Log.d(TAG, "Permission denied");
            Location emptyLocation = new Location("");
            emptyLocation.setLatitude(0);
            emptyLocation.setLatitude(0);
            Utilities.saveUserLocation(getContext(), new Location(""));
        }
    }

    private void updateWidgets() {
        /*Context context = getContext();
        // Setting the package ensures that only components in our app will receive the broadcast
        Intent dataUpdatedIntent = new Intent(ACTION_DATA_UPDATED)
                .setPackage(context.getPackageName());
        context.sendBroadcast(dataUpdatedIntent);*/
    }

    /**
     * Perform a sync right now
     *
     * @param context
     */
    public static void syncNow(Context context) {
        Log.d(TAG, "syncNow");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        ContentResolver.requestSync(getAccount(context), context.getString(R.string.content_provider_authority), bundle);
    }

    /**
     * Generates a mock account
     *
     * @param context
     * @return mock account.
     */
    public static Account getAccount(Context context) {
        Log.d(TAG, "getAccount");
        AccountManager accountManager = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
        Account newAccount = new Account(context.getString(R.string.app_name), context.getString(R.string.account_type));

        // If the password doesn't exist, the account doesn't exist
        if (accountManager.getPassword(newAccount) == null) {
            if (!accountManager.addAccountExplicitly(newAccount, "", null)) {
                Log.d(TAG, "error adding account");
                return null;
            }

            // If the account was just created, configure periodic sync
            setSyncPeriod(context, newAccount);
        }
        return newAccount;
    }

    private static void setSyncPeriod(Context context, Account account) {
        Log.d(TAG, "setSyncPeriod");
        final long SYNC_INTERVAL = 60;// * 60 * 6; //every 6 hours; todo set a preference, so this can be changed in a preferenceActivity
        String authority = context.getString(R.string.content_provider_authority);
        ContentResolver.setSyncAutomatically(account, context.getString(R.string.content_provider_authority), true);
        ContentResolver.addPeriodicSync(account, authority, new Bundle(), SYNC_INTERVAL);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed");
    }
}
