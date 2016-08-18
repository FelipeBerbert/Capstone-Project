package br.berbert.capstone.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;

import br.berbert.capstone.CapstoneApplication;
import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;
import br.berbert.capstone.adapters.AttributionsAdapter;
import br.berbert.capstone.adapters.PhotosAdapter;
import br.berbert.capstone.adapters.ReviewsAdapter;
import br.berbert.capstone.models.Photo;
import br.berbert.capstone.models.Place;
import br.berbert.capstone.models.PlaceDetailsResponse;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailFragment extends Fragment {

    public static final String ARG_PLACE = "PLACE";
    public static final String ARG_USER_LOCATION = "USER_LOCATION";
    public static final String ARG_NAVIGATE = "NAVIGATE";

    FrameLayout mTitleBackground;
    RecyclerView mRvPhotoList;
    RecyclerView mRvReviewList;
    PhotosAdapter mPhotosAdapter;
    ReviewsAdapter mReviewsAdapter;
    AttributionsAdapter mAttributionsAdapter;
    //TextView mDescription;
    TextView mName;
    TextView mAddress;
    TextView mPhone;
    TextView mDistance;
    RecyclerView mRvAttributions;
    LinearLayout mAttributionsContainer;
    FloatingActionButton mFab;
    ImageView mPicture;
    String mPlaceId;
    Location mUserLocation;
    Place mPlace;
    boolean mIsTabletLayout;
    boolean mNavigate;
    SimpleTarget target;
    ArrayList<String> mAttributionsList;
    public Tracker mTracker;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CapstoneApplication application = (CapstoneApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        initiateViews(rootView);
        mAttributionsList = new ArrayList<>();
        mRvPhotoList = (RecyclerView) rootView.findViewById(R.id.rv_photo_list);
        mRvPhotoList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRvPhotoList.setLayoutManager(llm);
        mRvReviewList = (RecyclerView) rootView.findViewById(R.id.rv_reviews);
        mRvReviewList.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRvReviewList.setLayoutManager(llm);
        mRvReviewList.setNestedScrollingEnabled(true);
        mRvAttributions = (RecyclerView) rootView.findViewById(R.id.rv_attributions);
        mRvAttributions.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRvAttributions.setLayoutManager(llm);
        mRvAttributions.setNestedScrollingEnabled(true);
        Bundle args = getArguments();
        if (args != null) {
            mPlaceId = args.getString(ARG_PLACE);
            mUserLocation = args.getParcelable(ARG_USER_LOCATION);
            mNavigate = args.getBoolean(ARG_NAVIGATE, false);
            requestDetails();
        }

        return rootView;
    }

    private void requestDetails() {
        Utilities.buildPlaceDetailRequest(getContext(), mPlaceId, new Response.Listener<PlaceDetailsResponse>() {
            @Override
            public void onResponse(PlaceDetailsResponse response) {
                mPlace = response.getResult();
                if (getContext() != null) {
                    mTracker.setScreenName(getContext().getString(R.string.lb_detail) + mPlace.getName());
                    mTracker.send(new HitBuilders.ScreenViewBuilder().build());
                }
                mAttributionsList.addAll(response.getHtml_attributions());
                for (Photo photo : mPlace.getPhotos()){
                    mAttributionsList.addAll(photo.getHtml_attributions());
                }
                if (mPlace != null) {
                    Log.d("CAPSTONE PROJECT", "Response: " + mPlace.getName());
                    bindViews();
                    if (mNavigate) {
                        navigateToPlace();
                    }
                } else {
                    Log.d("CAPSTONE PROJECT", "Response: Place is null");

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
        if (rootView.findViewById(R.id.tv_place_name) != null) { // If true, this is tablet layout
            mIsTabletLayout = true;
            mName = (TextView) rootView.findViewById(R.id.tv_place_name);
            mPicture = (ImageView) rootView.findViewById(R.id.iv_header_picture);
            mTitleBackground = (FrameLayout) rootView.findViewById(R.id.title_background);
            mFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
            mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToPlace();
                }
            });
        }
        //mDescription = (TextView) rootView.findViewById(R.id.tv_description);
        mAddress = (TextView) rootView.findViewById(R.id.tv_address);
        mPhone = (TextView) rootView.findViewById(R.id.tv_phone);
        mDistance = (TextView) rootView.findViewById(R.id.tv_distance);
        mAttributionsContainer = (LinearLayout) rootView.findViewById(R.id.ll_attributions_container);
    }

    private void bindViews() {
        //mDescription.setText(mPlace.getDescription());
        mAddress.setText(mPlace.getVicinity());
        mPhone.setText(mPlace.getPhoneNumber());
        if (mUserLocation == null)
            mUserLocation = Utilities.loadUserLocation(getContext());
        float distance = mPlace.getDistance(mUserLocation);
        if (distance > 0)
            mDistance.setText(getContext().getString(R.string.lb_meter, (long)distance));
        else
            mDistance.setText("-");
        mPhotosAdapter = new PhotosAdapter((CapstoneApplication) getActivity().getApplication(), mPlace.getPhotos());
        mReviewsAdapter = new ReviewsAdapter(mPlace.getReviews());
        mRvPhotoList.setAdapter(mPhotosAdapter);
        mRvReviewList.setAdapter(mReviewsAdapter);
        if (mAttributionsList.size() > 0) {
            mAttributionsAdapter = new AttributionsAdapter((CapstoneApplication) getActivity().getApplication(), getContext(), mAttributionsList);
            mRvAttributions.setAdapter(mAttributionsAdapter);
            mAttributionsContainer.setVisibility(View.VISIBLE);
        }

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

    /*public void setDescription(String text) {
        if (mDescription != null)
            mDescription.setText(text);
    }*/

    public void navigateToPlace(){
        if (mPlace != null){
            mTracker.send(new HitBuilders.EventBuilder()
                    .setCategory(getContext().getString(R.string.lb_category_click))
                    .setAction(getContext().getString(R.string.lb_navigate))
                    .setLabel(mPlace.getName())
                    .build());
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?&daddr="+
                            mPlace.getGeometry().getLocation().getLat()+","+
                            mPlace.getGeometry().getLocation().getLng()));
            startActivity(intent);
        }
    }

    public void setUserLocation(Location userLocation){
        mUserLocation = userLocation;
    }

    public interface Callback {
        void onResponse(Place place);
    }

}
