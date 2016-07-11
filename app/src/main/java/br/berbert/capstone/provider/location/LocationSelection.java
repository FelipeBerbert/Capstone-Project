/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.location;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;

/**
 * Selection for the {@code location} table.
 */
public class LocationSelection extends AbstractSelection<LocationSelection> {
    @Override
    protected Uri baseUri() {
        return LocationColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code LocationCursor} object, which is positioned before the first entry, or null.
     */
    public LocationCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new LocationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public LocationCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code LocationCursor} object, which is positioned before the first entry, or null.
     */
    public LocationCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new LocationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public LocationCursor query(Context context) {
        return query(context, null);
    }


    public LocationSelection id(long... value) {
        addEquals("location." + LocationColumns._ID, toObjectArray(value));
        return this;
    }

    public LocationSelection idNot(long... value) {
        addNotEquals("location." + LocationColumns._ID, toObjectArray(value));
        return this;
    }

    public LocationSelection orderById(boolean desc) {
        orderBy("location." + LocationColumns._ID, desc);
        return this;
    }

    public LocationSelection orderById() {
        return orderById(false);
    }

    public LocationSelection lat(Double... value) {
        addEquals(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection latNot(Double... value) {
        addNotEquals(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection latGt(double value) {
        addGreaterThan(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection latGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection latLt(double value) {
        addLessThan(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection latLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public LocationSelection orderByLat(boolean desc) {
        orderBy(LocationColumns.LAT, desc);
        return this;
    }

    public LocationSelection orderByLat() {
        orderBy(LocationColumns.LAT, false);
        return this;
    }

    public LocationSelection lng(Double... value) {
        addEquals(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection lngNot(Double... value) {
        addNotEquals(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection lngGt(double value) {
        addGreaterThan(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection lngGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection lngLt(double value) {
        addLessThan(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection lngLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public LocationSelection orderByLng(boolean desc) {
        orderBy(LocationColumns.LNG, desc);
        return this;
    }

    public LocationSelection orderByLng() {
        orderBy(LocationColumns.LNG, false);
        return this;
    }
}
