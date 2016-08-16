/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;

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

    public PlaceSelection lat(Double... value) {
        addEquals(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection latNot(Double... value) {
        addNotEquals(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection latGt(double value) {
        addGreaterThan(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection latGtEq(double value) {
        addGreaterThanOrEquals(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection latLt(double value) {
        addLessThan(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection latLtEq(double value) {
        addLessThanOrEquals(PlaceColumns.LAT, value);
        return this;
    }

    public PlaceSelection orderByLat(boolean desc) {
        orderBy(PlaceColumns.LAT, desc);
        return this;
    }

    public PlaceSelection orderByLat() {
        orderBy(PlaceColumns.LAT, false);
        return this;
    }

    public PlaceSelection lng(Double... value) {
        addEquals(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection lngNot(Double... value) {
        addNotEquals(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection lngGt(double value) {
        addGreaterThan(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection lngGtEq(double value) {
        addGreaterThanOrEquals(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection lngLt(double value) {
        addLessThan(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection lngLtEq(double value) {
        addLessThanOrEquals(PlaceColumns.LNG, value);
        return this;
    }

    public PlaceSelection orderByLng(boolean desc) {
        orderBy(PlaceColumns.LNG, desc);
        return this;
    }

    public PlaceSelection orderByLng() {
        orderBy(PlaceColumns.LNG, false);
        return this;
    }
}
