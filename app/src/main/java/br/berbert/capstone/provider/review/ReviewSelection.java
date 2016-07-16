/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.review;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import br.berbert.capstone.provider.base.AbstractSelection;
import br.berbert.capstone.provider.place.*;

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

    public ReviewSelection placeLat(Double... value) {
        addEquals(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeLatNot(Double... value) {
        addNotEquals(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeLatGt(double value) {
        addGreaterThan(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeLatGtEq(double value) {
        addGreaterThanOrEquals(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeLatLt(double value) {
        addLessThan(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection placeLatLtEq(double value) {
        addLessThanOrEquals(PlaceColumns.LAT, value);
        return this;
    }

    public ReviewSelection orderByPlaceLat(boolean desc) {
        orderBy(PlaceColumns.LAT, desc);
        return this;
    }

    public ReviewSelection orderByPlaceLat() {
        orderBy(PlaceColumns.LAT, false);
        return this;
    }

    public ReviewSelection placeLng(Double... value) {
        addEquals(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeLngNot(Double... value) {
        addNotEquals(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeLngGt(double value) {
        addGreaterThan(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeLngGtEq(double value) {
        addGreaterThanOrEquals(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeLngLt(double value) {
        addLessThan(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection placeLngLtEq(double value) {
        addLessThanOrEquals(PlaceColumns.LNG, value);
        return this;
    }

    public ReviewSelection orderByPlaceLng(boolean desc) {
        orderBy(PlaceColumns.LNG, desc);
        return this;
    }

    public ReviewSelection orderByPlaceLng() {
        orderBy(PlaceColumns.LNG, false);
        return this;
    }
}
