/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.place;

import br.berbert.capstone.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Place
 */
public interface PlaceModel extends BaseModel {

    /**
     * Equivalent to place_id.
     * Cannot be {@code null}.
     */
    @NonNull
    String getExternalId();

    /**
     * Name of the place.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Address.
     * Can be {@code null}.
     */
    @Nullable
    String getVicinity();

    /**
     * Get the {@code phone_number} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPhoneNumber();

    /**
     * Distance from the user's last location.
     * Can be {@code null}.
     */
    @Nullable
    Float getDistance();

    /**
     * Contains the geocoded latitude, longitude value for this place.
     */
    long getGeometryId();
}
