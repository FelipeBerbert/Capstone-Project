/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.location;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code location} table.
 */
public class LocationCursor extends AbstractCursor implements LocationModel {
    public LocationCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(LocationColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Latitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLat() {
        Double res = getDoubleOrNull(LocationColumns.LAT);
        return res;
    }

    /**
     * Longitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLng() {
        Double res = getDoubleOrNull(LocationColumns.LNG);
        return res;
    }
}
