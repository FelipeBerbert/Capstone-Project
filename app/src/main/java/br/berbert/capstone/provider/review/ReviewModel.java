/**
 * Classes generated for the Capstone Project, Udacity Android Nanodegree using the 
 * "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.review;

import br.berbert.capstone.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Review
 */
public interface ReviewModel extends BaseModel {

    /**
     * Author of the review.
     * Can be {@code null}.
     */
    @Nullable
    String getAuthorName();

    /**
     * Content of the review.
     * Can be {@code null}.
     */
    @Nullable
    String getText();

    /**
     * Rating of the review.
     * Can be {@code null}.
     */
    @Nullable
    Integer getRating();

    /**
     * The id of the place referenced by this review.
     */
    long getPlaceId();
}
