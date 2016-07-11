/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractCursor;
import br.berbert.capstone.provider.geometry.*;
import br.berbert.capstone.provider.location.*;

/**
 * Cursor wrapper for the {@code place} table.
 */
public class PlaceCursor extends AbstractCursor implements PlaceModel {
    public PlaceCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PlaceColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Equivalent to place_id.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getExternalId() {
        String res = getStringOrNull(PlaceColumns.EXTERNAL_ID);
        if (res == null)
            throw new NullPointerException("The value of 'external_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of the place.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(PlaceColumns.NAME);
        return res;
    }

    /**
     * Address.
     * Can be {@code null}.
     */
    @Nullable
    public String getVicinity() {
        String res = getStringOrNull(PlaceColumns.VICINITY);
        return res;
    }

    /**
     * Get the {@code phone_number} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPhoneNumber() {
        String res = getStringOrNull(PlaceColumns.PHONE_NUMBER);
        return res;
    }

    /**
     * Distance from the user's last location.
     * Can be {@code null}.
     */
    @Nullable
    public Float getDistance() {
        Float res = getFloatOrNull(PlaceColumns.DISTANCE);
        return res;
    }

    /**
     * Contains the geocoded latitude, longitude value for this place.
     */
    public long getGeometryId() {
        Long res = getLongOrNull(PlaceColumns.GEOMETRY_ID);
        if (res == null)
            throw new NullPointerException("The value of 'geometry_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    public long getGeometryLocationId() {
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
    public Double getGeometryLocationLat() {
        Double res = getDoubleOrNull(LocationColumns.LAT);
        return res;
    }

    /**
     * Longitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getGeometryLocationLng() {
        Double res = getDoubleOrNull(LocationColumns.LNG);
        return res;
    }
}
