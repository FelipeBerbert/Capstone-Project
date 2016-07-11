/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import android.net.Uri;
import android.provider.BaseColumns;

import br.berbert.capstone.provider.PlaceProvider;
import br.berbert.capstone.provider.geometry.GeometryColumns;
import br.berbert.capstone.provider.location.LocationColumns;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

/**
 * Place
 */
public class PlaceColumns implements BaseColumns {
    public static final String TABLE_NAME = "place";
    public static final Uri CONTENT_URI = Uri.parse(PlaceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Equivalent to place_id.
     */
    public static final String EXTERNAL_ID = "external_id";

    /**
     * Name of the place.
     */
    public static final String NAME = "name";

    /**
     * Address.
     */
    public static final String VICINITY = "vicinity";

    public static final String PHONE_NUMBER = "phone_number";

    /**
     * Distance from the user's last location.
     */
    public static final String DISTANCE = "distance";

    /**
     * Contains the geocoded latitude, longitude value for this place.
     */
    public static final String GEOMETRY_ID = "geometry_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            EXTERNAL_ID,
            NAME,
            VICINITY,
            PHONE_NUMBER,
            DISTANCE,
            GEOMETRY_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(EXTERNAL_ID) || c.contains("." + EXTERNAL_ID)) return true;
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(VICINITY) || c.contains("." + VICINITY)) return true;
            if (c.equals(PHONE_NUMBER) || c.contains("." + PHONE_NUMBER)) return true;
            if (c.equals(DISTANCE) || c.contains("." + DISTANCE)) return true;
            if (c.equals(GEOMETRY_ID) || c.contains("." + GEOMETRY_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_GEOMETRY = TABLE_NAME + "__" + GeometryColumns.TABLE_NAME;
}
