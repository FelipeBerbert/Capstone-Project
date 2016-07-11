/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.geometry;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;
import br.berbert.capstone.provider.location.*;

/**
 * Selection for the {@code geometry} table.
 */
public class GeometrySelection extends AbstractSelection<GeometrySelection> {
    @Override
    protected Uri baseUri() {
        return GeometryColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code GeometryCursor} object, which is positioned before the first entry, or null.
     */
    public GeometryCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new GeometryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public GeometryCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code GeometryCursor} object, which is positioned before the first entry, or null.
     */
    public GeometryCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new GeometryCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public GeometryCursor query(Context context) {
        return query(context, null);
    }


    public GeometrySelection id(long... value) {
        addEquals("geometry." + GeometryColumns._ID, toObjectArray(value));
        return this;
    }

    public GeometrySelection idNot(long... value) {
        addNotEquals("geometry." + GeometryColumns._ID, toObjectArray(value));
        return this;
    }

    public GeometrySelection orderById(boolean desc) {
        orderBy("geometry." + GeometryColumns._ID, desc);
        return this;
    }

    public GeometrySelection orderById() {
        return orderById(false);
    }

    public GeometrySelection locationId(long... value) {
        addEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public GeometrySelection locationIdNot(long... value) {
        addNotEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public GeometrySelection locationIdGt(long value) {
        addGreaterThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public GeometrySelection locationIdGtEq(long value) {
        addGreaterThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public GeometrySelection locationIdLt(long value) {
        addLessThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public GeometrySelection locationIdLtEq(long value) {
        addLessThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public GeometrySelection orderByLocationId(boolean desc) {
        orderBy(GeometryColumns.LOCATION_ID, desc);
        return this;
    }

    public GeometrySelection orderByLocationId() {
        orderBy(GeometryColumns.LOCATION_ID, false);
        return this;
    }

    public GeometrySelection locationLat(Double... value) {
        addEquals(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection locationLatNot(Double... value) {
        addNotEquals(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection locationLatGt(double value) {
        addGreaterThan(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection locationLatGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection locationLatLt(double value) {
        addLessThan(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection locationLatLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public GeometrySelection orderByLocationLat(boolean desc) {
        orderBy(LocationColumns.LAT, desc);
        return this;
    }

    public GeometrySelection orderByLocationLat() {
        orderBy(LocationColumns.LAT, false);
        return this;
    }

    public GeometrySelection locationLng(Double... value) {
        addEquals(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection locationLngNot(Double... value) {
        addNotEquals(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection locationLngGt(double value) {
        addGreaterThan(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection locationLngGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection locationLngLt(double value) {
        addLessThan(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection locationLngLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public GeometrySelection orderByLocationLng(boolean desc) {
        orderBy(LocationColumns.LNG, desc);
        return this;
    }

    public GeometrySelection orderByLocationLng() {
        orderBy(LocationColumns.LNG, false);
        return this;
    }
}
