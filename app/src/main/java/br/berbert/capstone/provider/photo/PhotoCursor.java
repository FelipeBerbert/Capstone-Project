/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.photo;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.models.Photo;
import br.berbert.capstone.provider.base.AbstractCursor;
import br.berbert.capstone.provider.place.*;
import br.berbert.capstone.provider.geometry.*;
import br.berbert.capstone.provider.location.*;

/**
 * Cursor wrapper for the {@code photo} table.
 */
public class PhotoCursor extends AbstractCursor implements PhotoModel {
    public PhotoCursor(Cursor cursor) {
        super(cursor);
    }


    public Photo getPhoto(){
        Photo photo = new Photo();
        photo.setPhoto_reference(getPhotoReference());
        photo.setHeight(getHeight()!=null?getHeight():0);
        photo.setWidth(getWidth()!=null?getWidth():0);
        return photo;
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PhotoColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Image width.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getWidth() {
        Integer res = getIntegerOrNull(PhotoColumns.WIDTH);
        return res;
    }

    /**
     * Image height.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getHeight() {
        Integer res = getIntegerOrNull(PhotoColumns.HEIGHT);
        return res;
    }

    /**
     * Image reference for download.
     * Can be {@code null}.
     */
    @Nullable
    public String getPhotoReference() {
        String res = getStringOrNull(PhotoColumns.PHOTO_REFERENCE);
        return res;
    }

    /**
     * The id of the place referenced by this photo.
     */
    public long getPlaceId() {
        Long res = getLongOrNull(PhotoColumns.PLACE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'place_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Equivalent to place_id.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getPlaceExternalId() {
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
    public String getPlaceName() {
        String res = getStringOrNull(PlaceColumns.NAME);
        return res;
    }

    /**
     * Address.
     * Can be {@code null}.
     */
    @Nullable
    public String getPlaceVicinity() {
        String res = getStringOrNull(PlaceColumns.VICINITY);
        return res;
    }

    /**
     * Get the {@code phone_number} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPlacePhoneNumber() {
        String res = getStringOrNull(PlaceColumns.PHONE_NUMBER);
        return res;
    }

    /**
     * Distance from the user's last location.
     * Can be {@code null}.
     */
    @Nullable
    public Float getPlaceDistance() {
        Float res = getFloatOrNull(PlaceColumns.DISTANCE);
        return res;
    }

    /**
     * Contains the geocoded latitude, longitude value for this place.
     */
    public long getPlaceGeometryId() {
        Long res = getLongOrNull(PlaceColumns.GEOMETRY_ID);
        if (res == null)
            throw new NullPointerException("The value of 'geometry_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    public long getPlaceGeometryLocationId() {
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
    public Double getPlaceGeometryLocationLat() {
        Double res = getDoubleOrNull(LocationColumns.LAT);
        return res;
    }

    /**
     * Longitude.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPlaceGeometryLocationLng() {
        Double res = getDoubleOrNull(LocationColumns.LNG);
        return res;
    }
}
