package br.berbert.capstone;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.util.Log;

import com.android.volley.Response;

import br.berbert.capstone.conn.GsonRequest;
import br.berbert.capstone.conn.VolleyConnection;
import br.berbert.capstone.models.NearbySearchResponse;
import br.berbert.capstone.models.PlaceDetailsResponse;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 16/06/2016.
 * General utility class.
 */
public class Utilities {
    private static final String TAG = "Capstone project utils";
    public static final String PREF_USER_LAT = "location.user_latitude";
    public static final String PREF_USER_LNG = "location.user_longitude";
    public static final String PREF_SYNC_LAT = "location.sync_latitude";
    public static final String PREF_SYNC_LNG = "location.sync_longitude";

    public static Palette.Swatch getColor(Bitmap bitmap) {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch color = null;
        if (palette.getDarkVibrantSwatch() != null)
            color = palette.getDarkVibrantSwatch();
        else if (palette.getVibrantSwatch() != null)
            color = palette.getVibrantSwatch();
        else if (palette.getLightVibrantSwatch() != null)
            color = palette.getLightVibrantSwatch();
        else if (palette.getDarkMutedSwatch() != null)
            color = palette.getDarkMutedSwatch();
        else if (palette.getMutedSwatch() != null)
            color = palette.getMutedSwatch();
        else if (palette.getLightMutedSwatch() != null)
            color = palette.getLightMutedSwatch();
        return color;
    }

    public static void buildPlacesRequest(Context context, Location location, Response.Listener<NearbySearchResponse> resultListener, Response.ErrorListener errorListener) {
        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        if (location.getProvider() != null && location.getProvider().equals("Mock") && BuildConfig.DEBUG)
            sb.append("location=" + -13.008348 + "," + -38.492842);
        else
            sb.append("location=").append(location.getLatitude()).append(",").append(location.getLongitude());
        sb.append("&radius=").append(context.getResources().getInteger(R.integer.search_distance));
        sb.append("&types=").append("amusement_park|aquarium|art_gallery|campground|museum|park|zoo");
        sb.append("&key=").append(BuildConfig.PLACES_API_KEY);

        String url = sb.toString();
        GsonRequest<NearbySearchResponse> request = new GsonRequest<>(url, NearbySearchResponse.class, null, resultListener, errorListener);
        VolleyConnection.getInstance(context).addToRequestQueue(request);
    }

    public static Uri extractUriFromAttribution(String attribution){
        String url = attribution.substring(attribution.indexOf("\"")+1, attribution.lastIndexOf("\""));
        return Uri.parse(url);
    }

    public static void buildPlaceDetailRequest(Context context, String placeId, Response.Listener<PlaceDetailsResponse> resultListener, Response.ErrorListener errorListener) {
        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json?");
        sb.append("key=" + BuildConfig.PLACES_API_KEY);
        sb.append("&placeid=" + placeId);
        //TODO add language parameter
        String url = sb.toString();

        GsonRequest<PlaceDetailsResponse> request = new GsonRequest<>(url, PlaceDetailsResponse.class, null, resultListener, errorListener);
        VolleyConnection.getInstance(context).addToRequestQueue(request);
    }

    public static int checkNetworkStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() == null)
            return -1;
        Log.d("Connection type", "" + connectivityManager.getActiveNetworkInfo().getType());
        return connectivityManager.getActiveNetworkInfo().getType();
    }

    /**
     * Returns true if location is activated
     */
    public static boolean checkLocationStatus(Context context) {
        if (context == null) return false;
//        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        int mode;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                mode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                mode = 0;
            }
        } else {
            Log.d("LOCATION PROVIDERS", Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED));
            // todo finnish this
            LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
                    || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
                mode = 1;
            else
                mode = 0;
        }

        return mode > 0;
    }


    public static void saveUserLocation(Context context, Location location) {
        if (context == null) return;
        SharedPreferences.Editor spEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        spEditor.putLong(PREF_USER_LAT, Double.doubleToRawLongBits(location.getLatitude()));
        spEditor.putLong(PREF_USER_LNG, Double.doubleToRawLongBits(location.getLongitude()));
        spEditor.apply();
        Log.d(TAG, "Saving user location. LAT:"+location.getLatitude()+" LNG:"+location.getLongitude());
    }
    public static void saveSyncLocation(Context context, Location location) {
        if (context == null) return;
        SharedPreferences.Editor spEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        spEditor.putLong(PREF_SYNC_LAT, Double.doubleToRawLongBits(location.getLatitude()));
        spEditor.putLong(PREF_SYNC_LNG, Double.doubleToRawLongBits(location.getLongitude()));
        spEditor.apply();
        Log.d(TAG, "Saving sync location. LAT:"+location.getLatitude()+" LNG:"+location.getLongitude());
    }
    public static Location loadUserLocation(Context context) {
        if (context == null) return new Location("");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        Location location = new Location("");
        location.setLatitude(Double.longBitsToDouble(sp.getLong(PREF_USER_LAT, 0)));
        location.setLongitude(Double.longBitsToDouble(sp.getLong(PREF_USER_LNG, 0)));
        Log.d(TAG, "Loading user location. LAT:"+location.getLatitude()+" LNG:"+location.getLongitude());
        return location;
    }
    public static Location loadSyncLocation(Context context) {
        if (context == null) return new Location("");
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        Location location = new Location("");
        location.setLatitude(Double.longBitsToDouble(sp.getLong(PREF_SYNC_LAT, 0)));
        location.setLongitude(Double.longBitsToDouble(sp.getLong(PREF_SYNC_LNG, 0)));
        Log.d(TAG, "Loading sync location. LAT:"+location.getLatitude()+" LNG:"+location.getLongitude());
        return location;
    }

    public static boolean checkPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }
}
