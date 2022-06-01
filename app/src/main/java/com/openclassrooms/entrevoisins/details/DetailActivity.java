package com.openclassrooms.entrevoisins.details;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.openclassrooms.entrevoisins.R;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        // Open the detailFragment
        openDetailFragment();

    }

    private void openDetailFragment() {

        // A Bundle with parameter come from user click on item list.
        Bundle extras = getIntent().getExtras();
        String neighbourName = extras.getString("neighbourName");

        // Initialize fragment
        Fragment detailFragment = new DetailFragment();
        // Pass Arguments
        detailFragment.setArguments(extras);
        //open Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, detailFragment)
                .commit();
    }

}