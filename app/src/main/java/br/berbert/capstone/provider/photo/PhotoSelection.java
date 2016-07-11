/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.photo;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;
import br.berbert.capstone.provider.place.*;
import br.berbert.capstone.provider.geometry.*;
import br.berbert.capstone.provider.location.*;

/**
 * Selection for the {@code photo} table.
 */
public class PhotoSelection extends AbstractSelection<PhotoSelection> {
    @Override
    protected Uri baseUri() {
        return PhotoColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PhotoCursor} object, which is positioned before the first entry, or null.
     */
    public PhotoCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PhotoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PhotoCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PhotoCursor} object, which is positioned before the first entry, or null.
     */
    public PhotoCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PhotoCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PhotoCursor query(Context context) {
        return query(context, null);
    }


    public PhotoSelection id(long... value) {
        addEquals("photo." + PhotoColumns._ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection idNot(long... value) {
        addNotEquals("photo." + PhotoColumns._ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection orderById(boolean desc) {
        orderBy("photo." + PhotoColumns._ID, desc);
        return this;
    }

    public PhotoSelection orderById() {
        return orderById(false);
    }

    public PhotoSelection width(Integer... value) {
        addEquals(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection widthNot(Integer... value) {
        addNotEquals(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection widthGt(int value) {
        addGreaterThan(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection widthGtEq(int value) {
        addGreaterThanOrEquals(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection widthLt(int value) {
        addLessThan(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection widthLtEq(int value) {
        addLessThanOrEquals(PhotoColumns.WIDTH, value);
        return this;
    }

    public PhotoSelection orderByWidth(boolean desc) {
        orderBy(PhotoColumns.WIDTH, desc);
        return this;
    }

    public PhotoSelection orderByWidth() {
        orderBy(PhotoColumns.WIDTH, false);
        return this;
    }

    public PhotoSelection height(Integer... value) {
        addEquals(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection heightNot(Integer... value) {
        addNotEquals(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection heightGt(int value) {
        addGreaterThan(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection heightGtEq(int value) {
        addGreaterThanOrEquals(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection heightLt(int value) {
        addLessThan(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection heightLtEq(int value) {
        addLessThanOrEquals(PhotoColumns.HEIGHT, value);
        return this;
    }

    public PhotoSelection orderByHeight(boolean desc) {
        orderBy(PhotoColumns.HEIGHT, desc);
        return this;
    }

    public PhotoSelection orderByHeight() {
        orderBy(PhotoColumns.HEIGHT, false);
        return this;
    }

    public PhotoSelection photoReference(String... value) {
        addEquals(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection photoReferenceNot(String... value) {
        addNotEquals(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection photoReferenceLike(String... value) {
        addLike(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection photoReferenceContains(String... value) {
        addContains(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection photoReferenceStartsWith(String... value) {
        addStartsWith(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection photoReferenceEndsWith(String... value) {
        addEndsWith(PhotoColumns.PHOTO_REFERENCE, value);
        return this;
    }

    public PhotoSelection orderByPhotoReference(boolean desc) {
        orderBy(PhotoColumns.PHOTO_REFERENCE, desc);
        return this;
    }

    public PhotoSelection orderByPhotoReference() {
        orderBy(PhotoColumns.PHOTO_REFERENCE, false);
        return this;
    }

    public PhotoSelection placeId(long... value) {
        addEquals(PhotoColumns.PLACE_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeIdNot(long... value) {
        addNotEquals(PhotoColumns.PLACE_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeIdGt(long value) {
        addGreaterThan(PhotoColumns.PLACE_ID, value);
        return this;
    }

    public PhotoSelection placeIdGtEq(long value) {
        addGreaterThanOrEquals(PhotoColumns.PLACE_ID, value);
        return this;
    }

    public PhotoSelection placeIdLt(long value) {
        addLessThan(PhotoColumns.PLACE_ID, value);
        return this;
    }

    public PhotoSelection placeIdLtEq(long value) {
        addLessThanOrEquals(PhotoColumns.PLACE_ID, value);
        return this;
    }

    public PhotoSelection orderByPlaceId(boolean desc) {
        orderBy(PhotoColumns.PLACE_ID, desc);
        return this;
    }

    public PhotoSelection orderByPlaceId() {
        orderBy(PhotoColumns.PLACE_ID, false);
        return this;
    }

    public PhotoSelection placeExternalId(String... value) {
        addEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection placeExternalIdNot(String... value) {
        addNotEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection placeExternalIdLike(String... value) {
        addLike(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection placeExternalIdContains(String... value) {
        addContains(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection placeExternalIdStartsWith(String... value) {
        addStartsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection placeExternalIdEndsWith(String... value) {
        addEndsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public PhotoSelection orderByPlaceExternalId(boolean desc) {
        orderBy(PlaceColumns.EXTERNAL_ID, desc);
        return this;
    }

    public PhotoSelection orderByPlaceExternalId() {
        orderBy(PlaceColumns.EXTERNAL_ID, false);
        return this;
    }

    public PhotoSelection placeName(String... value) {
        addEquals(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection placeNameNot(String... value) {
        addNotEquals(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection placeNameLike(String... value) {
        addLike(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection placeNameContains(String... value) {
        addContains(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection placeNameStartsWith(String... value) {
        addStartsWith(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection placeNameEndsWith(String... value) {
        addEndsWith(PlaceColumns.NAME, value);
        return this;
    }

    public PhotoSelection orderByPlaceName(boolean desc) {
        orderBy(PlaceColumns.NAME, desc);
        return this;
    }

    public PhotoSelection orderByPlaceName() {
        orderBy(PlaceColumns.NAME, false);
        return this;
    }

    public PhotoSelection placeVicinity(String... value) {
        addEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection placeVicinityNot(String... value) {
        addNotEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection placeVicinityLike(String... value) {
        addLike(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection placeVicinityContains(String... value) {
        addContains(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection placeVicinityStartsWith(String... value) {
        addStartsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection placeVicinityEndsWith(String... value) {
        addEndsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public PhotoSelection orderByPlaceVicinity(boolean desc) {
        orderBy(PlaceColumns.VICINITY, desc);
        return this;
    }

    public PhotoSelection orderByPlaceVicinity() {
        orderBy(PlaceColumns.VICINITY, false);
        return this;
    }

    public PhotoSelection placePhoneNumber(String... value) {
        addEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection placePhoneNumberNot(String... value) {
        addNotEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection placePhoneNumberLike(String... value) {
        addLike(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection placePhoneNumberContains(String... value) {
        addContains(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection placePhoneNumberStartsWith(String... value) {
        addStartsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection placePhoneNumberEndsWith(String... value) {
        addEndsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public PhotoSelection orderByPlacePhoneNumber(boolean desc) {
        orderBy(PlaceColumns.PHONE_NUMBER, desc);
        return this;
    }

    public PhotoSelection orderByPlacePhoneNumber() {
        orderBy(PlaceColumns.PHONE_NUMBER, false);
        return this;
    }

    public PhotoSelection placeDistance(Float... value) {
        addEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection placeDistanceNot(Float... value) {
        addNotEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection placeDistanceGt(float value) {
        addGreaterThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection placeDistanceGtEq(float value) {
        addGreaterThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection placeDistanceLt(float value) {
        addLessThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection placeDistanceLtEq(float value) {
        addLessThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public PhotoSelection orderByPlaceDistance(boolean desc) {
        orderBy(PlaceColumns.DISTANCE, desc);
        return this;
    }

    public PhotoSelection orderByPlaceDistance() {
        orderBy(PlaceColumns.DISTANCE, false);
        return this;
    }

    public PhotoSelection placeGeometryId(long... value) {
        addEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeGeometryIdNot(long... value) {
        addNotEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeGeometryIdGt(long value) {
        addGreaterThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryIdGtEq(long value) {
        addGreaterThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryIdLt(long value) {
        addLessThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryIdLtEq(long value) {
        addLessThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryId(boolean desc) {
        orderBy(PlaceColumns.GEOMETRY_ID, desc);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryId() {
        orderBy(PlaceColumns.GEOMETRY_ID, false);
        return this;
    }

    public PhotoSelection placeGeometryLocationId(long... value) {
        addEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeGeometryLocationIdNot(long... value) {
        addNotEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public PhotoSelection placeGeometryLocationIdGt(long value) {
        addGreaterThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationIdGtEq(long value) {
        addGreaterThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationIdLt(long value) {
        addLessThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationIdLtEq(long value) {
        addLessThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationId(boolean desc) {
        orderBy(GeometryColumns.LOCATION_ID, desc);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationId() {
        orderBy(GeometryColumns.LOCATION_ID, false);
        return this;
    }

    public PhotoSelection placeGeometryLocationLat(Double... value) {
        addEquals(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLatNot(Double... value) {
        addNotEquals(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLatGt(double value) {
        addGreaterThan(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLatGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLatLt(double value) {
        addLessThan(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLatLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationLat(boolean desc) {
        orderBy(LocationColumns.LAT, desc);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationLat() {
        orderBy(LocationColumns.LAT, false);
        return this;
    }

    public PhotoSelection placeGeometryLocationLng(Double... value) {
        addEquals(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLngNot(Double... value) {
        addNotEquals(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLngGt(double value) {
        addGreaterThan(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLngGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLngLt(double value) {
        addLessThan(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection placeGeometryLocationLngLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationLng(boolean desc) {
        orderBy(LocationColumns.LNG, desc);
        return this;
    }

    public PhotoSelection orderByPlaceGeometryLocationLng() {
        orderBy(LocationColumns.LNG, false);
        return this;
    }
}
