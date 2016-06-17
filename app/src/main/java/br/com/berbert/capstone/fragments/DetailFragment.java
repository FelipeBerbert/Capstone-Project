package br.com.berbert.capstone.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.berbert.capstone.R;
import br.com.berbert.capstone.Utilities;
import br.com.berbert.capstone.models.Place;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailFragment extends Fragment {

    public static final String ARG_PLACE = "PLACE";

    FrameLayout mTitleBackground;
    TextView mDescription;
    TextView mName;
    ImageView mPicture;
    Place mPlace;
    boolean mIsTabletLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle args = getArguments();
        if (args != null) {
            mPlace = args.getParcelable(ARG_PLACE);
        }

        initiateViews(rootView);

        if (mPlace != null){
            bindViews();
        }

        return rootView;
    }

    private void initiateViews(View rootView){
        if(rootView.findViewById(R.id.tv_place_name)!= null){
            mIsTabletLayout = true;
            mName = (TextView) rootView.findViewById(R.id.tv_place_name);
            mPicture = (ImageView) rootView.findViewById(R.id.iv_header_picture);
            mTitleBackground = (FrameLayout) rootView.findViewById(R.id.title_background);
        }
        mDescription = (TextView) rootView.findViewById(R.id.tv_description);
    }

    private void bindViews(){
        mDescription.setText(mPlace.getDescription());
        if(mIsTabletLayout){
            mName.setText(mPlace.getName());
            Bitmap headerBitmap = BitmapFactory.decodeResource(getResources(), mPlace.getPicture());
            mPicture.setImageDrawable(getResources().getDrawable(mPlace.getPicture()));
            Palette.Swatch scrimColor = Utilities.getColor(headerBitmap);

            if (scrimColor != null) {
                mTitleBackground.setBackgroundColor(scrimColor.getRgb());
                mName.setTextColor(scrimColor.getTitleTextColor());
            }
        }
    }

    public void setDescription(String text){
        if(mDescription != null)
            mDescription.setText(text);
    }

}
