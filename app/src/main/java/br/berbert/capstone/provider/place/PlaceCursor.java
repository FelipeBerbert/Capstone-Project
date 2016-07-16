/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import br.berbert.capstone.models.Geometry;
import br.berbert.capstone.models.Location;
import br.berbert.capstone.models.Photo;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.models.Review;
import br.berbert.capstone.provider.base.AbstractCursor;
import br.berbert.capstone.provider.photo.PhotoColumns;
import br.berbert.capstone.provider.photo.PhotoCursor;
import br.berbert.capstone.provider.photo.PhotoSelection;
import br.berbert.capstone.provider.review.ReviewCursor;
import br.berbert.capstone.provider.review.ReviewSelection;

/**
 * Cursor wrapper for the {@code place} table.
 */
public class PlaceCursor extends AbstractCursor implements PlaceModel {
    public PlaceCursor(Cursor cursor) {
        super(cursor);
    }


    public Place getPlace(Context context, boolean shouldGetJoinTables) {
        Place place = new Place();
        place.setDistance(getDistance() != null ? getDistance() : 0);
        place.setName(getName());
        place.setPhoneNumber(getPhoneNumber());
        place.setPlaceId(getExternalId());
        place.setVicinity(getVicinity());
        Location location = new Location();
        if(getLat() != null && getLng() != null) {
            location.setLng(getLng());
            location.setLat(getLat());
            Geometry geometry = new Geometry();
            geometry.setLocation(location);
            place.setGeometry(geometry);
        }

        if (shouldGetJoinTables) {
            ReviewSelection rsWhere = new ReviewSelection();
            rsWhere.placeId(getId());
            ReviewCursor rCursor = rsWhere.query(context.getContentResolver());
            if (rCursor.moveToFirst()) {
                ArrayList<Review> reviewList = new ArrayList<>();
                do {
                    reviewList.add(rCursor.getReview());
                } while (rCursor.moveToNext());
                place.setReviews(reviewList);
            }
            rCursor.close();
            PhotoSelection psWhere = new PhotoSelection();
            psWhere.placeId(getId());
            PhotoCursor pCursor = psWhere.query(context.getContentResolver());
            if (pCursor.moveToFirst()) {
                ArrayList<Photo> photoList = new ArrayList<>();
                do {
                    photoList.add(pCursor.getPhoto());
                } while (rCursor.moveToNext());
                place.setPhotos(photoList);
            }
            pCursor.close();
        }

        return place;
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PlaceColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Equivalent to place_id.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getExternalId() {
        String res = getStringOrNull(PlaceColumns.EXTERNAL_ID);
        if (res == null)
            throw new NullPointerException("The value of 'external_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of the place.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(PlaceColumns.NAME);
        return res;
    }

    /**
     * Address.
     * Can be {@code null}.
     */
    @Nullable
    public String getVicinity() {
        String res = getStringOrNull(PlaceColumns.VICINITY);
        return res;
    }

    /**
     * Get the {@code phone_number} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPhoneNumber() {
        String res = getStringOrNull(PlaceColumns.PHONE_NUMBER);
        return res;
    }

    /**
     * Distance from the user's last location.
     * Can be {@code null}.
     */
    @Nullable
    public Float getDistance() {
        Float res = getFloatOrNull(PlaceColumns.DISTANCE);
        return res;
    }

    /**
     * Contains the geocoded latitude value for this place.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLat() {
        Double res = getDoubleOrNull(PlaceColumns.LAT);
        return res;
    }

    /**
     * Contains the geocoded longitude value for this place.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLng() {
        Double res = getDoubleOrNull(PlaceColumns.LNG);
        return res;
    }

    /**
     * Reference for main photo.
     * Can be {@code null}.
     */
    @Nullable
    public String getMainPhotoReference(Context context) {
        PhotoSelection where = new PhotoSelection();
        where.id(getId());
        String[] selection = {PhotoColumns.PHOTO_REFERENCE};
        Cursor c = context.getContentResolver().query(PhotoColumns.CONTENT_URI, selection,
                where.sel(), where.args(), null);
        PhotoCursor pc = new PhotoCursor(c);
        String photoReference;
        if (pc.moveToFirst()) {
            photoReference = pc.getPhotoReference();
        } else
            photoReference = null;
        if (c != null)
            c.close();
        return photoReference;
    }
}
