package br.com.berbert.capstone.fragments;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import br.com.berbert.capstone.R;
import br.com.berbert.capstone.Utilities;
import br.com.berbert.capstone.adapters.PhotosAdapter;
import br.com.berbert.capstone.models.Place;
import br.com.berbert.capstone.models.PlaceDetailsResponse;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailFragment extends Fragment {

    public static final String ARG_PLACE = "PLACE";
    public static final String ARG_USER_LOCATION = "USER_LOCATION";

    FrameLayout mTitleBackground;
    RecyclerView mRvPhotoList;
    PhotosAdapter mPhotosAdapter;
    TextView mDescription;
    TextView mName;
    TextView mAddress;
    TextView mPhone;
    TextView mDistance;
    ImageView mPicture;
    String mPlaceId;
    Location mUserLocation;
    Place mPlace;
    boolean mIsTabletLayout;
    SimpleTarget target;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        initiateViews(rootView);
        mRvPhotoList = (RecyclerView) rootView.findViewById(R.id.rv_photo_list);
        mRvPhotoList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRvPhotoList.setLayoutManager(llm);
        Bundle args = getArguments();
        if (args != null) {
            mPlaceId = args.getString(ARG_PLACE);
            mUserLocation = args.getParcelable(ARG_USER_LOCATION);
            requestDetails();
        }

        return rootView;
    }

    private void requestDetails() {
        Utilities.buildPlaceDetailRequest(getContext(), mPlaceId, new Response.Listener<PlaceDetailsResponse>() {
            @Override
            public void onResponse(PlaceDetailsResponse response) {
                Log.d("CAPSTONE PROJECT", "Response: " + response.getResult().getName());
                mPlace = response.getResult();
                if (mPlace != null) {
                    bindViews();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("CAPSTONE PROJECT", "Response: " + error.getMessage());
                ((Callback) getActivity()).onResponse(null);
            }
        });
    }

    private void initiateViews(View rootView) {
        if (rootView.findViewById(R.id.tv_place_name) != null) {
            mIsTabletLayout = true;
            mName = (TextView) rootView.findViewById(R.id.tv_place_name);
            mPicture = (ImageView) rootView.findViewById(R.id.iv_header_picture);
            mTitleBackground = (FrameLayout) rootView.findViewById(R.id.title_background);
        }
        mDescription = (TextView) rootView.findViewById(R.id.tv_description);
        mAddress = (TextView) rootView.findViewById(R.id.tv_address);
        mPhone = (TextView) rootView.findViewById(R.id.tv_phone);
        mDistance = (TextView) rootView.findViewById(R.id.tv_distance);
    }

    private void bindViews() {
        mDescription.setText(mPlace.getDescription());
        mAddress.setText(mPlace.getVicinity());
        mPhone.setText(mPlace.getPhoneNumber());
        mDistance.setText(getContext().getString(R.string.lb_meter, (long) mPlace.getDistance(mUserLocation)));
        mPhotosAdapter = new PhotosAdapter(mPlace.getPhotos());
        mPhotosAdapter.notifyDataSetChanged();
        mRvPhotoList.setAdapter(mPhotosAdapter);
        if (mIsTabletLayout) {  // If it is a tablet, all views are in the fragment
            mName.setText(mPlace.getName());
            if(mPlace.getPhotos().size() > 0) {
                target = new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                        Palette.Swatch scrimColor = Utilities.getColor(bitmap);
                        if (scrimColor != null) {
                            mTitleBackground.setBackgroundColor(scrimColor.getRgb());
                            mName.setTextColor(scrimColor.getTitleTextColor());
                        }
                        mPicture.setImageBitmap(bitmap);
                    }
                };

                mPlace.getPhotos().get(0).fetchPhoto(getContext(), target);
            }
            //BitmapFactory.decodeResource(getResources(), mPlace.getPicture());
        } else { // If it is a smartphone, there are some views on the activity to be handled
            ((Callback) getActivity()).onResponse(mPlace);
        }
    }

    public void setDescription(String text) {
        if (mDescription != null)
            mDescription.setText(text);
    }

    public interface Callback {
        void onResponse(Place place);
    }

}
