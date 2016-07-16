/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code place} table.
 */
public class PlaceContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PlaceColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PlaceSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PlaceSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Equivalent to place_id.
     */
    public PlaceContentValues putExternalId(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("externalId must not be null");
        mContentValues.put(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }


    /**
     * Name of the place.
     */
    public PlaceContentValues putName(@Nullable String value) {
        mContentValues.put(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceContentValues putNameNull() {
        mContentValues.putNull(PlaceColumns.NAME);
        return this;
    }

    /**
     * Address.
     */
    public PlaceContentValues putVicinity(@Nullable String value) {
        mContentValues.put(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceContentValues putVicinityNull() {
        mContentValues.putNull(PlaceColumns.VICINITY);
        return this;
    }

    public PlaceContentValues putPhoneNumber(@Nullable String value) {
        mContentValues.put(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceContentValues putPhoneNumberNull() {
        mContentValues.putNull(PlaceColumns.PHONE_NUMBER);
        return this;
    }

    /**
     * Distance from the user's last location.
     */
    public PlaceContentValues putDistance(@Nullable Float value) {
        mContentValues.put(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceContentValues putDistanceNull() {
        mContentValues.putNull(PlaceColumns.DISTANCE);
        return this;
    }

    /**
     * Contains the geocoded latitude value for this place.
     */
    public PlaceContentValues putLat(@Nullable Double value) {
        mContentValues.put(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceContentValues putLatNull() {
        mContentValues.putNull(PlaceColumns.LAT);
        return this;
    }

    /**
     * Contains the geocoded longitude value for this place.
     */
    public PlaceContentValues putLng(@Nullable Double value) {
        mContentValues.put(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceContentValues putLngNull() {
        mContentValues.putNull(PlaceColumns.LNG);
        return this;
    }
}
