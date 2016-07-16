/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.photo;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code photo} table.
 */
public class PhotoContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PhotoColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PhotoSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PhotoSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Image width.
     */
    public PhotoContentValues putWidth(@Nullable Integer value) {
        mContentValues.put(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoContentValues putWidthNull() {
        mContentValues.putNull(PhotoColumns.WIDTH);
        return this;
    }

    /**
     * Image height.
     */
    public PhotoContentValues putHeight(@Nullable Integer value) {
        mContentValues.put(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoContentValues putHeightNull() {
        mContentValues.putNull(PhotoColumns.HEIGHT);
        return this;
    }

    /**
     * Image reference for download.
     */
    public PhotoContentValues putPhotoReference(@Nullable String value) {
        mContentValues.put(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoContentValues putPhotoReferenceNull() {
        mContentValues.putNull(PhotoColumns.PHOTO_REFERENCE);
        return this;
    }

    /**
     * The id of the place referenced by this photo.
     */
    public PhotoContentValues putPlaceId(long value) {
        mContentValues.put(PhotoColumns.PLACE_ID, value);
        return this;
    }

}
