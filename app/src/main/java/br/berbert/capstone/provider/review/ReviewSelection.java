/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.review;

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
 * Selection for the {@code review} table.
 */
public class ReviewSelection extends AbstractSelection<ReviewSelection> {
    @Override
    protected Uri baseUri() {
        return ReviewColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ReviewCursor} object, which is positioned before the first entry, or null.
     */
    public ReviewCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ReviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ReviewCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ReviewCursor} object, which is positioned before the first entry, or null.
     */
    public ReviewCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ReviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ReviewCursor query(Context context) {
        return query(context, null);
    }


    public ReviewSelection id(long... value) {
        addEquals("review." + ReviewColumns._ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection idNot(long... value) {
        addNotEquals("review." + ReviewColumns._ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection orderById(boolean desc) {
        orderBy("review." + ReviewColumns._ID, desc);
        return this;
    }

    public ReviewSelection orderById() {
        return orderById(false);
    }

    public ReviewSelection authorName(String... value) {
        addEquals(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection authorNameNot(String... value) {
        addNotEquals(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection authorNameLike(String... value) {
        addLike(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection authorNameContains(String... value) {
        addContains(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection authorNameStartsWith(String... value) {
        addStartsWith(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection authorNameEndsWith(String... value) {
        addEndsWith(ReviewColumns.AUTHOR_NAME, value);
        return this;
    }

    public ReviewSelection orderByAuthorName(boolean desc) {
        orderBy(ReviewColumns.AUTHOR_NAME, desc);
        return this;
    }

    public ReviewSelection orderByAuthorName() {
        orderBy(ReviewColumns.AUTHOR_NAME, false);
        return this;
    }

    public ReviewSelection text(String... value) {
        addEquals(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection textNot(String... value) {
        addNotEquals(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection textLike(String... value) {
        addLike(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection textContains(String... value) {
        addContains(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection textStartsWith(String... value) {
        addStartsWith(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection textEndsWith(String... value) {
        addEndsWith(ReviewColumns.TEXT, value);
        return this;
    }

    public ReviewSelection orderByText(boolean desc) {
        orderBy(ReviewColumns.TEXT, desc);
        return this;
    }

    public ReviewSelection orderByText() {
        orderBy(ReviewColumns.TEXT, false);
        return this;
    }

    public ReviewSelection rating(Integer... value) {
        addEquals(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection ratingNot(Integer... value) {
        addNotEquals(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection ratingGt(int value) {
        addGreaterThan(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection ratingGtEq(int value) {
        addGreaterThanOrEquals(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection ratingLt(int value) {
        addLessThan(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection ratingLtEq(int value) {
        addLessThanOrEquals(ReviewColumns.RATING, value);
        return this;
    }

    public ReviewSelection orderByRating(boolean desc) {
        orderBy(ReviewColumns.RATING, desc);
        return this;
    }

    public ReviewSelection orderByRating() {
        orderBy(ReviewColumns.RATING, false);
        return this;
    }

    public ReviewSelection placeId(long... value) {
        addEquals(ReviewColumns.PLACE_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeIdNot(long... value) {
        addNotEquals(ReviewColumns.PLACE_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeIdGt(long value) {
        addGreaterThan(ReviewColumns.PLACE_ID, value);
        return this;
    }

    public ReviewSelection placeIdGtEq(long value) {
        addGreaterThanOrEquals(ReviewColumns.PLACE_ID, value);
        return this;
    }

    public ReviewSelection placeIdLt(long value) {
        addLessThan(ReviewColumns.PLACE_ID, value);
        return this;
    }

    public ReviewSelection placeIdLtEq(long value) {
        addLessThanOrEquals(ReviewColumns.PLACE_ID, value);
        return this;
    }

    public ReviewSelection orderByPlaceId(boolean desc) {
        orderBy(ReviewColumns.PLACE_ID, desc);
        return this;
    }

    public ReviewSelection orderByPlaceId() {
        orderBy(ReviewColumns.PLACE_ID, false);
        return this;
    }

    public ReviewSelection placeExternalId(String... value) {
        addEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection placeExternalIdNot(String... value) {
        addNotEquals(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection placeExternalIdLike(String... value) {
        addLike(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection placeExternalIdContains(String... value) {
        addContains(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection placeExternalIdStartsWith(String... value) {
        addStartsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection placeExternalIdEndsWith(String... value) {
        addEndsWith(PlaceColumns.EXTERNAL_ID, value);
        return this;
    }

    public ReviewSelection orderByPlaceExternalId(boolean desc) {
        orderBy(PlaceColumns.EXTERNAL_ID, desc);
        return this;
    }

    public ReviewSelection orderByPlaceExternalId() {
        orderBy(PlaceColumns.EXTERNAL_ID, false);
        return this;
    }

    public ReviewSelection placeName(String... value) {
        addEquals(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection placeNameNot(String... value) {
        addNotEquals(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection placeNameLike(String... value) {
        addLike(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection placeNameContains(String... value) {
        addContains(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection placeNameStartsWith(String... value) {
        addStartsWith(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection placeNameEndsWith(String... value) {
        addEndsWith(PlaceColumns.NAME, value);
        return this;
    }

    public ReviewSelection orderByPlaceName(boolean desc) {
        orderBy(PlaceColumns.NAME, desc);
        return this;
    }

    public ReviewSelection orderByPlaceName() {
        orderBy(PlaceColumns.NAME, false);
        return this;
    }

    public ReviewSelection placeVicinity(String... value) {
        addEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection placeVicinityNot(String... value) {
        addNotEquals(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection placeVicinityLike(String... value) {
        addLike(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection placeVicinityContains(String... value) {
        addContains(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection placeVicinityStartsWith(String... value) {
        addStartsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection placeVicinityEndsWith(String... value) {
        addEndsWith(PlaceColumns.VICINITY, value);
        return this;
    }

    public ReviewSelection orderByPlaceVicinity(boolean desc) {
        orderBy(PlaceColumns.VICINITY, desc);
        return this;
    }

    public ReviewSelection orderByPlaceVicinity() {
        orderBy(PlaceColumns.VICINITY, false);
        return this;
    }

    public ReviewSelection placePhoneNumber(String... value) {
        addEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection placePhoneNumberNot(String... value) {
        addNotEquals(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection placePhoneNumberLike(String... value) {
        addLike(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection placePhoneNumberContains(String... value) {
        addContains(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection placePhoneNumberStartsWith(String... value) {
        addStartsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection placePhoneNumberEndsWith(String... value) {
        addEndsWith(PlaceColumns.PHONE_NUMBER, value);
        return this;
    }

    public ReviewSelection orderByPlacePhoneNumber(boolean desc) {
        orderBy(PlaceColumns.PHONE_NUMBER, desc);
        return this;
    }

    public ReviewSelection orderByPlacePhoneNumber() {
        orderBy(PlaceColumns.PHONE_NUMBER, false);
        return this;
    }

    public ReviewSelection placeDistance(Float... value) {
        addEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection placeDistanceNot(Float... value) {
        addNotEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection placeDistanceGt(float value) {
        addGreaterThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection placeDistanceGtEq(float value) {
        addGreaterThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection placeDistanceLt(float value) {
        addLessThan(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection placeDistanceLtEq(float value) {
        addLessThanOrEquals(PlaceColumns.DISTANCE, value);
        return this;
    }

    public ReviewSelection orderByPlaceDistance(boolean desc) {
        orderBy(PlaceColumns.DISTANCE, desc);
        return this;
    }

    public ReviewSelection orderByPlaceDistance() {
        orderBy(PlaceColumns.DISTANCE, false);
        return this;
    }

    public ReviewSelection placeGeometryId(long... value) {
        addEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeGeometryIdNot(long... value) {
        addNotEquals(PlaceColumns.GEOMETRY_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeGeometryIdGt(long value) {
        addGreaterThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryIdGtEq(long value) {
        addGreaterThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryIdLt(long value) {
        addLessThan(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryIdLtEq(long value) {
        addLessThanOrEquals(PlaceColumns.GEOMETRY_ID, value);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryId(boolean desc) {
        orderBy(PlaceColumns.GEOMETRY_ID, desc);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryId() {
        orderBy(PlaceColumns.GEOMETRY_ID, false);
        return this;
    }

    public ReviewSelection placeGeometryLocationId(long... value) {
        addEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeGeometryLocationIdNot(long... value) {
        addNotEquals(GeometryColumns.LOCATION_ID, toObjectArray(value));
        return this;
    }

    public ReviewSelection placeGeometryLocationIdGt(long value) {
        addGreaterThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationIdGtEq(long value) {
        addGreaterThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationIdLt(long value) {
        addLessThan(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationIdLtEq(long value) {
        addLessThanOrEquals(GeometryColumns.LOCATION_ID, value);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationId(boolean desc) {
        orderBy(GeometryColumns.LOCATION_ID, desc);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationId() {
        orderBy(GeometryColumns.LOCATION_ID, false);
        return this;
    }

    public ReviewSelection placeGeometryLocationLat(Double... value) {
        addEquals(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLatNot(Double... value) {
        addNotEquals(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLatGt(double value) {
        addGreaterThan(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLatGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLatLt(double value) {
        addLessThan(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLatLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LAT, value);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationLat(boolean desc) {
        orderBy(LocationColumns.LAT, desc);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationLat() {
        orderBy(LocationColumns.LAT, false);
        return this;
    }

    public ReviewSelection placeGeometryLocationLng(Double... value) {
        addEquals(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLngNot(Double... value) {
        addNotEquals(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLngGt(double value) {
        addGreaterThan(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLngGtEq(double value) {
        addGreaterThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLngLt(double value) {
        addLessThan(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeGeometryLocationLngLtEq(double value) {
        addLessThanOrEquals(LocationColumns.LNG, value);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationLng(boolean desc) {
        orderBy(LocationColumns.LNG, desc);
        return this;
    }

    public ReviewSelection orderByPlaceGeometryLocationLng() {
        orderBy(LocationColumns.LNG, false);
        return this;
    }
}
