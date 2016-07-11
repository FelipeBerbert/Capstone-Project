/**
*Classes generated for the Capstone Project, Udacity Android Nanodegree using the "Android ContentProvider Generator" (https://github.com/BoD/android-contentprovider-generator)
*/
package br.berbert.capstone.provider.geometry;

import br.berbert.capstone.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Geometry
 */
public interface GeometryModel extends BaseModel {

    /**
     * Contains the geocoded latitude,longitude value for this place.
     */
    long getLocationId();
}
