/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.geometry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code geometry} table.
 */
public class GeometryContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return GeometryColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable GeometrySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable GeometrySelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    public GeometryContentValues putLocationId(long value) {
        mContentValues.put(GeometryColumns.LOCATION_ID, value);
        return this;
    }

}
