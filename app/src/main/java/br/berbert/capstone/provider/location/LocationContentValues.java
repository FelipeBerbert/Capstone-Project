/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.location;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code location} table.
 */
public class LocationContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return LocationColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable LocationSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable LocationSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Latitude.
     */
    public LocationContentValues putLat(@Nullable Double value) {
        mContentValues.put(LocationColumns.LAT, value);
        return this;
    }

    public LocationContentValues putLatNull() {
        mContentValues.putNull(LocationColumns.LAT);
        return this;
    }

    /**
     * Longitude.
     */
    public LocationContentValues putLng(@Nullable Double value) {
        mContentValues.put(LocationColumns.LNG, value);
        return this;
    }

    public LocationContentValues putLngNull() {
        mContentValues.putNull(LocationColumns.LNG);
        return this;
    }
}
