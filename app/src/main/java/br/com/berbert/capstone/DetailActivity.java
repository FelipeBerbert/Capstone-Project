package br.com.berbert.capstone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import br.com.berbert.capstone.fragments.DetailFragment;
import br.com.berbert.capstone.models.Place;


/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String PARAM_PLACE = "place";

    Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        ImageView headerPicture = (ImageView) findViewById(R.id.iv_header_picture);
        View titleBackground = findViewById(R.id.title_background);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setupActionBar();

        Place place = getIntent().getParcelableExtra(PARAM_PLACE);
        setTitle(place.getName());

        if (savedInstanceState == null) {

            Bundle args = new Bundle();
            args.putParcelable(DetailFragment.ARG_PLACE, place);

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_detail, fragment)
                    .commit();

//            supportPostponeEnterTransition();
        }
        //DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frag_detail);
        Bitmap headerBitmap = BitmapFactory.decodeResource(getResources(), place.getPicture());
        Palette.Swatch scrimColor = Utilities.getColor(headerBitmap);

        if (scrimColor != null) {
            ctl.setContentScrimColor(scrimColor.getRgb());
            ctl.setStatusBarScrim(null);
            titleBackground.setBackgroundColor(scrimColor.getRgb());
            ctl.setExpandedTitleColor(scrimColor.getTitleTextColor());
            ctl.setCollapsedTitleTextColor(scrimColor.getBodyTextColor());
            //todo Find a way to also change the back arrow color
        }

        headerPicture.setImageDrawable(getResources().getDrawable(place.getPicture()));
        //detailFragment.setDescription(place.getDescription());
    }

    private void setupActionBar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

}
