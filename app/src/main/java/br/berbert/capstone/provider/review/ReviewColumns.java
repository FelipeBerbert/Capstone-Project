/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.review;

import android.net.Uri;
import android.provider.BaseColumns;

import br.berbert.capstone.provider.PlaceProvider;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.place.PlaceColumns;
import br.berbert.capstone.provider.review.ReviewColumns;

/**
 * Review
 */
public class ReviewColumns implements BaseColumns {
    public static final String TABLE_NAME = "review";
    public static final Uri CONTENT_URI = Uri.parse(PlaceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Author of the review.
     */
    public static final String AUTHOR_NAME = "author_name";

    /**
     * Content of the review.
     */
    public static final String TEXT = "text";

    /**
     * Rating of the review.
     */
    public static final String RATING = "rating";

    /**
     * The id of the place referenced by this review.
     */
    public static final String PLACE_ID = "place_id";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            AUTHOR_NAME,
            TEXT,
            RATING,
            PLACE_ID
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(AUTHOR_NAME) || c.contains("." + AUTHOR_NAME)) return true;
            if (c.equals(TEXT) || c.contains("." + TEXT)) return true;
            if (c.equals(RATING) || c.contains("." + RATING)) return true;
            if (c.equals(PLACE_ID) || c.contains("." + PLACE_ID)) return true;
        }
        return false;
    }

    public static final String PREFIX_PLACE = TABLE_NAME + "__" + PlaceColumns.TABLE_NAME;
}
