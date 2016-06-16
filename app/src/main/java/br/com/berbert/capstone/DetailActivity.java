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

    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        ImageView headerPicture = (ImageView) findViewById(R.id.iv_header_picture);
        View titleBackground = findViewById(R.id.title_background);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setupActionBar();

        Place place = (Place) getIntent().getSerializableExtra(PARAM_PLACE);
        setTitle(place.getName());
//        Palette.from

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frag_detail);
        Bitmap headerBitmap = BitmapFactory.decodeResource(getResources(), place.getPicture());
        Palette palette = Palette.from(headerBitmap).generate();
        Palette.Swatch scrimColor = null;
        if (palette.getDarkVibrantSwatch() != null)
            scrimColor = palette.getDarkVibrantSwatch();
        else if (palette.getVibrantSwatch() != null)
            scrimColor = palette.getVibrantSwatch();
        else if (palette.getLightVibrantSwatch() != null)
            scrimColor = palette.getLightVibrantSwatch();
        else if (palette.getDarkMutedSwatch() != null)
            scrimColor = palette.getDarkMutedSwatch();
        else if (palette.getMutedSwatch() != null)
            scrimColor = palette.getMutedSwatch();
        else if (palette.getLightMutedSwatch() != null)
            scrimColor = palette.getLightMutedSwatch();

        if (scrimColor != null) {
            ctl.setContentScrimColor(scrimColor.getRgb());
            ctl.setStatusBarScrim(null);
            titleBackground.setBackgroundColor(scrimColor.getRgb());
            ctl.setExpandedTitleColor(scrimColor.getTitleTextColor());
            ctl.setCollapsedTitleTextColor(scrimColor.getBodyTextColor());
            //todo Find a way to also change the back arrow color
        }

        headerPicture.setImageDrawable(getResources().getDrawable(place.getPicture()));
        detailFragment.setDescription(place.getDescription());
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

}
