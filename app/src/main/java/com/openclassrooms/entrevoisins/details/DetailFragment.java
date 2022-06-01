package com.openclassrooms.entrevoisins.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;


public class DetailFragment extends Fragment {

    // initialize variable
    TextView headerNeighbourName;
    TextView cardNeighbourName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // initialize view
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // assign Variables
        headerNeighbourName = view.findViewById(R.id.detailNeighbourHeaderNameTextView);
        cardNeighbourName = view.findViewById(R.id.detailNeighbourCardNameTextView);

        // check condition
        if (getArguments() != null){

            // when arguments is not equal to null
            // put the neighbour name value
            String nHeaderName = getArguments().getString("neighbourName");
            String nName = getArguments().getString("neighbourName");

            // set the name to the textView
            headerNeighbourName.setText(nHeaderName);
            cardNeighbourName.setText(nName);
        }

        // return view
        return view;
    }
}