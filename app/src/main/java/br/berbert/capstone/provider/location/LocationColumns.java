/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.location;

import android.net.Uri;
import android.provider.BaseColumns;

import br.berbert.capstone.provider.PlaceProvider;
import br.berbert.capstone.provider.geometry.GeometryColumns;
import br.berbert.capstone.provider.location.LocationColumns;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

/**
 * Location
 */
public class LocationColumns implements BaseColumns {
    public static final String TABLE_NAME = "location";
    public static final Uri CONTENT_URI = Uri.parse(PlaceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Latitude.
     */
    public static final String LAT = "lat";

    /**
     * Longitude.
     */
    public static final String LNG = "lng";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            LAT,
            LNG
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(LAT) || c.contains("." + LAT)) return true;
            if (c.equals(LNG) || c.contains("." + LNG)) return true;
        }
        return false;
    }

}
