/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.geometry;

import android.net.Uri;
import android.provider.BaseColumns;

import br.berbert.capstone.provider.PlaceProvider;
import br.berbert.capstone.provider.geometry.GeometryColumns;
import br.berbert.capstone.provider.location.LocationColumns;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

/**
 * Geometry
 */
public class GeometryColumns implements BaseColumns {
    public static final String TABLE_NAME = "geometry";
    public static final Uri CONTENT_URI = Uri.parse(PlaceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    public static final String LOCATION_ID = "location_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            LOCATION_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(LOCATION_ID) || c.contains("." + LOCATION_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_LOCATION = TABLE_NAME + "__" + LocationColumns.TABLE_NAME;
}
