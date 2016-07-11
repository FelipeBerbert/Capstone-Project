/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.geometry;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractCursor;
import br.berbert.capstone.provider.location.*;

/**
 * Cursor wrapper for the {@code geometry} table.
 */
public class GeometryCursor extends AbstractCursor implements GeometryModel {
    public GeometryCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(GeometryColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    public long getLocationId() {
        Long res = getLongOrNull(GeometryColumns.LOCATION_ID);
        if (res == null)
            throw new NullPointerException("The value of 'location_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Latitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLocationLat() {
        Double res = getDoubleOrNull(LocationColumns.LAT);
        return res;
    }

    /**
     * Longitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLocationLng() {
        Double res = getDoubleOrNull(LocationColumns.LNG);
        return res;
    }
}
