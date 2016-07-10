package br.berbert.capstone;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;

import br.berbert.capstone.adapters.PlacesAdapter;
import br.berbert.capstone.fragments.DetailFragment;
import br.berbert.capstone.fragments.PlacesFragment;
import br.berbert.capstone.models.Place;

public class MainActivity extends AppCompatActivity implements PlacesFragment.Callback {

    private static final String DETAIL_FRAGMENT_TAG = "DETAILFRAGMENTTAG";

    boolean mIsTabletLayout;
    CardView mDetailContainer;
    PlacesFragment mPlacesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlacesFragment = (PlacesFragment) getSupportFragmentManager().findFragmentById(R.id.frag_places_list);

        mDetailContainer = (CardView) findViewById(R.id.detail_fragment_container);
        if (mDetailContainer != null) {
            mIsTabletLayout = true;
            if (savedInstanceState == null) {
                mDetailContainer.setVisibility(View.GONE);
                DetailFragment fragment = new DetailFragment();
                /*if (contentUri != null) {
                    Bundle args = new Bundle();
                    args.putParcelable(DetailFragment.DETAIL_URI, contentUri);
                    fragment.setArguments(args);
                }*/

                getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, fragment, DETAIL_FRAGMENT_TAG).commit();
//                placesFragment.selectFirstPosition();
            }
        }
    }

    @Override
    public void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh, Location userLocation) {
        if (mIsTabletLayout) {
            Bundle args = new Bundle();
//            args.putParcelable(DetailFragment.ARG_PLACE, item);
            args.putString(DetailFragment.ARG_PLACE, item.getPlaceId());
            args.putParcelable(DetailFragment.ARG_USER_LOCATION, userLocation);
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(args);

//            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//                TransitionManager.beginDelayedTransition(mDetailContainer);

            getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, fragment, DETAIL_FRAGMENT_TAG).commit();
            mDetailContainer.setVisibility(View.VISIBLE);

        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.PARAM_PLACE, item.getPlaceId());
            intent.putExtra(DetailActivity.PARAM_PLACE_NAME, item.getName());
            intent.putExtra(DetailActivity.PARAM_USER_LOCATION, mPlacesFragment.mUserLocation);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Pair<View, String> transitionImagePair = new Pair<>((View) vh.picture, getString(R.string.transition_image));
                Pair<View, String> distanceTransitionPair = new Pair<>((View) vh.distanceBack, getString(R.string.transition_distance));
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, transitionImagePair, distanceTransitionPair);//(this, imageSharedView, imageTransitionName);
                startActivity(intent, transitionActivityOptions.toBundle());
            } else
                startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mPlacesFragment.permissionGranted();
        } else {
            mPlacesFragment.permissionDenied();
        }
    }


}
