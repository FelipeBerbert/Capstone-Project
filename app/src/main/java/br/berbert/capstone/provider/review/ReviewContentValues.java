/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.review;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.berbert.capstone.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code review} table.
 */
public class ReviewContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ReviewColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ReviewSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable ReviewSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Author of the review.
     */
    public ReviewContentValues putAuthorName(@Nullable String value) {
        mContentValues.put(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewContentValues putAuthorNameNull() {
        mContentValues.putNull(ReviewColumns.AUTHOR_NAME);
        return this;
    }

    /**
     * Content of the review.
     */
    public ReviewContentValues putText(@Nullable String value) {
        mContentValues.put(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewContentValues putTextNull() {
        mContentValues.putNull(ReviewColumns.TEXT);
        return this;
    }

    /**
     * Rating of the review.
     */
    public ReviewContentValues putRating(@Nullable Integer value) {
        mContentValues.put(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewContentValues putRatingNull() {
        mContentValues.putNull(ReviewColumns.RATING);
        return this;
    }

    /**
     * The id of the place referenced by this review.
     */
    public ReviewContentValues putPlaceId(long value) {
        mContentValues.put(ReviewColumns.PLACE_ID, value);
        return this;
    }

}
