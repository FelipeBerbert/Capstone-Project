package br.berbert.capstone;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import br.berbert.capstone.fragments.DetailFragment;
import br.berbert.capstone.models.Place;


/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailActivity extends AppCompatActivity implements DetailFragment.Callback {

    public static final String PARAM_PLACE = "place";
    public static final String PARAM_PLACE_NAME = "place_name";
    public static final String PARAM_NAVIGATE = "navigate";
    public static final String PARAM_USER_LOCATION = "user_location";

    Toolbar mToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    ImageView mHeaderPicture;
    View mTitleBackground;
    SimpleTarget mTarget;
    FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mHeaderPicture = (ImageView) findViewById(R.id.iv_header_picture);
        mTitleBackground = findViewById(R.id.title_background);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        setupActionBar();

        String placeId = getIntent().getStringExtra(PARAM_PLACE);
        Location userLocation = getIntent().getParcelableExtra(PARAM_USER_LOCATION);
        boolean navigate = getIntent().getBooleanExtra(PARAM_NAVIGATE, false);
        setTitle(getIntent().getStringExtra(PARAM_PLACE_NAME)); // For some reason, setting the title after the server response is not working

        if (savedInstanceState == null) {

            Bundle args = new Bundle();
            args.putString(DetailFragment.ARG_PLACE, placeId);
            args.putParcelable(DetailFragment.ARG_USER_LOCATION, userLocation);
            args.putBoolean(DetailFragment.ARG_NAVIGATE, navigate);

            final DetailFragment fragment = new DetailFragment();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_detail, fragment)
                    .commit();

            mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragment.navigateToPlace();
                }
            });
        }

    }

    private void bindViews(Place place){
        if (place != null) {
            setTitle(place.getName());
            mTarget = new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                    Palette.Swatch scrimColor = Utilities.getColor(resource);

                    if (scrimColor != null) {
                        mCollapsingToolbarLayout.setContentScrimColor(scrimColor.getRgb());
                        mCollapsingToolbarLayout.setStatusBarScrim(null);
                        mTitleBackground.setBackgroundColor(scrimColor.getRgb());
                        mCollapsingToolbarLayout.setExpandedTitleColor(scrimColor.getTitleTextColor());
                        mCollapsingToolbarLayout.setCollapsedTitleTextColor(scrimColor.getBodyTextColor());
                        //todo Find a way to also change the back arrow color
                    }
                    mHeaderPicture.setImageBitmap(resource);
                }

            };
            if (place.getPhotos().size()>0) {
                place.getPhotos().get(0).fetchPhoto(this, mTarget);
            }
        }
    }

    private void setupActionBar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResponse(Place place) {
        bindViews(place);
    }
}
