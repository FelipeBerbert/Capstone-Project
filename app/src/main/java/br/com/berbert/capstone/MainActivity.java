package br.com.berbert.capstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.berbert.capstone.fragments.PlacesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlacesFragment placesFragment = (PlacesFragment) getSupportFragmentManager().findFragmentById(R.id.frag_places_list);
    }
}
