/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.photo;

import br.berbert.capstone.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Photo
 */
public interface PhotoModel extends BaseModel {

    /**
     * Image width.
     * Can be {@code null}.
     */
    @Nullable
    Integer getWidth();

    /**
     * Image height.
     * Can be {@code null}.
     */
    @Nullable
    Integer getHeight();

    /**
     * Image reference for download.
     * Can be {@code null}.
     */
    @Nullable
    String getPhotoReference();

    /**
     * The id of the place referenced by this photo.
     */
    long getPlaceId();
}
