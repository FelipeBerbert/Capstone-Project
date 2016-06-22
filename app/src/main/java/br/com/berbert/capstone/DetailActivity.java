package br.com.berbert.capstone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import br.com.berbert.capstone.fragments.DetailFragment;
import br.com.berbert.capstone.models.Place;
import br.com.berbert.capstone.models.PlaceDetailsResponse;


/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailActivity extends AppCompatActivity implements DetailFragment.Callback {

    public static final String PARAM_PLACE = "place";

    Toolbar mToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    ImageView mHeaderPicture;
    View mTitleBackground;
    SimpleTarget mTarget;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mHeaderPicture = (ImageView) findViewById(R.id.iv_header_picture);
        mTitleBackground = findViewById(R.id.title_background);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setupActionBar();

        String placeId = getIntent().getStringExtra(PARAM_PLACE);

        if (savedInstanceState == null) {

            Bundle args = new Bundle();
            args.putString(DetailFragment.ARG_PLACE, placeId);

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_detail, fragment)
                    .commit();

//            supportPostponeEnterTransition();
        }

    }

    private void bindViews(Place place){
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
        setTitle(place.getName());
        place.fetchPhoto(this, mTarget);

    }

    private void setupActionBar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public void onResponse(Place place) {
        bindViews(place);
    }
}
