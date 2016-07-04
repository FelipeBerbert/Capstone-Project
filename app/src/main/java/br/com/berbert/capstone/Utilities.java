package br.com.berbert.capstone;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.support.v7.graphics.Palette;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import br.com.berbert.capstone.conn.GsonRequest;
import br.com.berbert.capstone.conn.VolleyConnection;
import br.com.berbert.capstone.models.PlaceDetailsResponse;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 16/06/2016.
 */
public class Utilities {

    public static Palette.Swatch getColor(Bitmap bitmap){
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

    public static void buildPlaceDetailRequest(Context context, String placeId, Response.Listener<PlaceDetailsResponse> resultListener, Response.ErrorListener errorListener){
            StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/details/json?");
            sb.append("key=" + BuildConfig.PLACES_API_KEY);
            sb.append("&placeid=" + placeId);
            //TODO add language parameter
            String url = sb.toString();

            GsonRequest<PlaceDetailsResponse> request = new GsonRequest<>(url, PlaceDetailsResponse.class, null, resultListener, errorListener);
            VolleyConnection.getInstance(context).addToRequestQueue(request);
    }

    public static int checkNetworkStatus(Context context){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() == null)
                return -1;
            Log.d("Connection type", ""+connectivityManager.getActiveNetworkInfo().getType());
            return connectivityManager.getActiveNetworkInfo().getType();
    }
}