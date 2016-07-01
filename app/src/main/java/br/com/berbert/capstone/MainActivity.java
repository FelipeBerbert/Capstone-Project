package br.com.berbert.capstone;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import br.com.berbert.capstone.adapters.PlacesAdapter;
import br.com.berbert.capstone.fragments.DetailFragment;
import br.com.berbert.capstone.fragments.PlacesFragment;
import br.com.berbert.capstone.models.Place;

public class MainActivity extends AppCompatActivity implements PlacesFragment.Callback {

    private static final String DETAIL_FRAGMENT_TAG = "DETAILFRAGMENTTAG";

    boolean mIsTabletLayout;
    CardView mDetailContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlacesFragment placesFragment = (PlacesFragment) getSupportFragmentManager().findFragmentById(R.id.frag_places_list);

        mDetailContainer = (CardView) findViewById(R.id.detail_fragment_container);
        if (mDetailContainer != null){
            mIsTabletLayout = true;
            if (savedInstanceState == null)
                mDetailContainer.setVisibility(View.GONE);

            if (savedInstanceState == null) {
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
    public void onItemSelected(Place item, PlacesAdapter.PlacesViewHolder vh) {
        if (mIsTabletLayout){
            Bundle args = new Bundle();
//            args.putParcelable(DetailFragment.ARG_PLACE, item);
            args.putString(DetailFragment.ARG_PLACE, item.getPlaceId());
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
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                String transitionName = getString(R.string.transition_detail);
                View sharedView = vh.picture;
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, sharedView, transitionName);
                startActivity(intent, transitionActivityOptions.toBundle());
            } else
                startActivity(intent);
        }
    }


}
