package br.com.berbert.capstone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import br.com.berbert.capstone.fragments.DetailFragment;
import br.com.berbert.capstone.models.Place;


/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 12/06/2016.
 *
 */
public class DetailActivity extends AppCompatActivity {

    public static final String PARAM_PLACE = "place";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Place place = (Place) getIntent().getSerializableExtra(PARAM_PLACE);

        ImageView headerPicture = (ImageView) findViewById(R.id.iv_header_picture);

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frag_detail);

        headerPicture.setImageDrawable(getResources().getDrawable(place.getPicture()));
        detailFragment.setDescription(place.getDescription());
    }

}
