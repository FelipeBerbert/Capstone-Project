/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;
import br.berbert.capstone.provider.geometry.*;
import br.berbert.capstone.provider.location.*;

/**
 * Selection for the {@code place} table.
 */
public class PlaceSelection extends AbstractSelection<PlaceSelection> {
    @Override
    protected Uri baseUri() {
        return PlaceColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PlaceCursor} object, which is positioned before the first entry, or null.
     */
    public PlaceCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PlaceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PlaceCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PlaceCursor} object, which is positioned before the first entry, or null.
     */
    public PlaceCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PlaceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PlaceCursor query(Context context) {
        return query(context, null);
    }


    public PlaceSelection id(long... value) {
        addEquals("place." + PlaceColumns._ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection idNot(long... value) {
        addNotEquals("place." + PlaceColumns._ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection orderById(boolean desc) {
        orderBy("place." + PlaceColumns._ID, desc);
        return this;
    }

    public PlaceSelection orderById() {
        return orderById(false);
    }

    public PlaceSelection externalId(String... value) {
        addEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection externalIdNot(String... value) {
        addNotEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection externalIdLike(String... value) {
        addLike(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection externalIdContains(String... value) {
        addContains(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection externalIdStartsWith(String... value) {
        addStartsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection externalIdEndsWith(String... value) {
        addEndsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PlaceSelection orderByExternalId(boolean desc) {
        orderBy(PlaceColumns.EXTERNAL_ID, desc);
        return this;
    }

    public PlaceSelection orderByExternalId() {
        orderBy(PlaceColumns.EXTERNAL_ID, false);
        return this;
    }

    public PlaceSelection name(String... value) {
        addEquals(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection nameNot(String... value) {
        addNotEquals(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection nameLike(String... value) {
        addLike(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection nameContains(String... value) {
        addContains(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection nameStartsWith(String... value) {
        addStartsWith(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection nameEndsWith(String... value) {
        addEndsWith(PlaceColumns.NAME, value);
        return this;
    }

    public PlaceSelection orderByName(boolean desc) {
        orderBy(PlaceColumns.NAME, desc);
        return this;
    }

    public PlaceSelection orderByName() {
        orderBy(PlaceColumns.NAME, false);
        return this;
    }

    public PlaceSelection vicinity(String... value) {
        addEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection vicinityNot(String... value) {
        addNotEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection vicinityLike(String... value) {
        addLike(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection vicinityContains(String... value) {
        addContains(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection vicinityStartsWith(String... value) {
        addStartsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection vicinityEndsWith(String... value) {
        addEndsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public PlaceSelection orderByVicinity(boolean desc) {
        orderBy(PlaceColumns.VICINITY, desc);
        return this;
    }

    public PlaceSelection orderByVicinity() {
        orderBy(PlaceColumns.VICINITY, false);
        return this;
    }

    public PlaceSelection phoneNumber(String... value) {
        addEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection phoneNumberNot(String... value) {
        addNotEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection phoneNumberLike(String... value) {
        addLike(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection phoneNumberContains(String... value) {
        addContains(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection phoneNumberStartsWith(String... value) {
        addStartsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection phoneNumberEndsWith(String... value) {
        addEndsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PlaceSelection orderByPhoneNumber(boolean desc) {
        orderBy(PlaceColumns.PHONE_NUMBER, desc);
        return this;
    }

    public PlaceSelection orderByPhoneNumber() {
        orderBy(PlaceColumns.PHONE_NUMBER, false);
        return this;
    }

    public PlaceSelection distance(Float... value) {
        addEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection distanceNot(Float... value) {
        addNotEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection distanceGt(float value) {
        addGreaterThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection distanceGtEq(float value) {
        addGreaterThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection distanceLt(float value) {
        addLessThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection distanceLtEq(float value) {
        addLessThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PlaceSelection orderByDistance(boolean desc) {
        orderBy(PlaceColumns.DISTANCE, desc);
        return this;
    }

    public PlaceSelection orderByDistance() {
        orderBy(PlaceColumns.DISTANCE, false);
        return this;
    }

    public PlaceSelection geometryId(long... value) {
        addEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection geometryIdNot(long... value) {
        addNotEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection geometryIdGt(long value) {
        addGreaterThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PlaceSelection geometryIdGtEq(long value) {
        addGreaterThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PlaceSelection geometryIdLt(long value) {
        addLessThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PlaceSelection geometryIdLtEq(long value) {
        addLessThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PlaceSelection orderByGeometryId(boolean desc) {
        orderBy(PlaceColumns.GEOMETRY_ID, desc);
        return this;
    }

    public PlaceSelection orderByGeometryId() {
        orderBy(PlaceColumns.GEOMETRY_ID, false);
        return this;
    }

    public PlaceSelection geometryLocationId(long... value) {
        addEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection geometryLocationIdNot(long... value) {
        addNotEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public PlaceSelection geometryLocationIdGt(long value) {
        addGreaterThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PlaceSelection geometryLocationIdGtEq(long value) {
        addGreaterThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PlaceSelection geometryLocationIdLt(long value) {
        addLessThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PlaceSelection geometryLocationIdLtEq(long value) {
        addLessThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PlaceSelection orderByGeometryLocationId(boolean desc) {
        orderBy(GeometryColumns.LOCATION_ID, desc);
        return this;
    }

    public PlaceSelection orderByGeometryLocationId() {
        orderBy(GeometryColumns.LOCATION_ID, false);
        return this;
    }

    public PlaceSelection geometryLocationLat(Double... value) {
        addEquals(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection geometryLocationLatNot(Double... value) {
        addNotEquals(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection geometryLocationLatGt(double value) {
        addGreaterThan(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection geometryLocationLatGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection geometryLocationLatLt(double value) {
        addLessThan(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection geometryLocationLatLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public PlaceSelection orderByGeometryLocationLat(boolean desc) {
        orderBy(LocationColumns.LAT, desc);
        return this;
    }

    public PlaceSelection orderByGeometryLocationLat() {
        orderBy(LocationColumns.LAT, false);
        return this;
    }

    public PlaceSelection geometryLocationLng(Double... value) {
        addEquals(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection geometryLocationLngNot(Double... value) {
        addNotEquals(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection geometryLocationLngGt(double value) {
        addGreaterThan(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection geometryLocationLngGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection geometryLocationLngLt(double value) {
        addLessThan(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection geometryLocationLngLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public PlaceSelection orderByGeometryLocationLng(boolean desc) {
        orderBy(LocationColumns.LNG, desc);
        return this;
    }

    public PlaceSelection orderByGeometryLocationLng() {
        orderBy(LocationColumns.LNG, false);
        return this;
    }
}
