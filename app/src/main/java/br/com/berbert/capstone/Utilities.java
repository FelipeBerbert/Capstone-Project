package br.com.berbert.capstone;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 16/06/2016.
 */
public class Utilities {

    public static Palette.Swatch getColor(Bitmap bitmap){
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch color = null;
        if (palette.getDarkVibrantSwatch() != null)
            color = palette.getDarkVibrantSwatch();
        else if (palette.getVibrantSwatch() != null)
            color = palette.getVibrantSwatch();
        else if (palette.getLightVibrantSwatch() != null)
            color = palette.getLightVibrantSwatch();
        else if (palette.getDarkMutedSwatch() != null)
            color = palette.getDarkMutedSwatch();
        else if (palette.getMutedSwatch() != null)
            color = palette.getMutedSwatch();
        else if (palette.getLightMutedSwatch() != null)
            color = palette.getLightMutedSwatch();
        return color;
    }
}
