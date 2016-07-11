/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.photo;

import android.net.Uri;
import android.provider.BaseColumns;

import br.berbert.capstone.provider.PlaceProvider;
import br.berbert.capstone.provider.geometry.GeometryColumns;
import br.berbert.capstone.provider.location.LocationColumns;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

/**
 * Photo
 */
public class PhotoColumns implements BaseColumns {
    public static final String TABLE_NAME = "photo";
    public static final Uri CONTENT_URI = Uri.parse(PlaceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Image width.
     */
    public static final String WIDTH = "width";

    /**
     * Image height.
     */
    public static final String HEIGHT = "height";

    /**
     * Image reference for download.
     */
    public static final String PHOTO_REFERENCE = "photo_reference";

    /**
     * The id of the place referenced by this photo.
     */
    public static final String PLACE_ID = "place_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            WIDTH,
            HEIGHT,
            PHOTO_REFERENCE,
            PLACE_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(WIDTH) || c.contains("." + WIDTH)) return true;
            if (c.equals(HEIGHT) || c.contains("." + HEIGHT)) return true;
            if (c.equals(PHOTO_REFERENCE) || c.contains("." + PHOTO_REFERENCE)) return true;
            if (c.equals(PLACE_ID) || c.contains("." + PLACE_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_PLACE = TABLE_NAME + "__" + PlaceColumns.TABLE_NAME;
}
