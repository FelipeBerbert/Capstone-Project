/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.location;

import br.berbert.capstone.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Location
 */
public interface LocationModel extends BaseModel {

    /**
     * Latitude.
     * Can be {@code null}.
     */
    @Nullable
    Double getLat();

    /**
     * Longitude.
     * Can be {@code null}.
     */
    @Nullable
    Double getLng();
}
