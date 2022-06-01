package com.openclassrooms.entrevoisins.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;


public class DetailFragment extends Fragment {

    // initialize variable
    ImageView headerAvatar;
    TextView headerNeighbourName;
    TextView cardNeighbourName;
    TextView cardNeighbourAddress;
    TextView cardNeighbourPhoneNumber;
    TextView cardNeighbourAboutMe;
    TextView cardNeighbourSocialLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // initialize view
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // assign Variables
        headerAvatar = view.findViewById(R.id.detailNeighbourAvatarImageView);
        headerNeighbourName = view.findViewById(R.id.detailNeighbourHeaderNameTextView);
        cardNeighbourName = view.findViewById(R.id.detailNeighbourCardNameTextView);
        cardNeighbourAddress = view.findViewById(R.id.detailNeighbourAdressTextView);
        cardNeighbourPhoneNumber = view.findViewById(R.id.detailNeighbourPhoneTextView);
        cardNeighbourAboutMe = view.findViewById(R.id.detailTextViewNeighbourAboutme);
        cardNeighbourSocialLink = view.findViewById(R.id.detailNeighbourSocialLinkTextView);

        // check condition
        if (getArguments() != null){

            // when arguments is not equal to null
            // put the neighbour name value
            String nName = getArguments().getString("neighbourName");
            String nAdress = getArguments().getString("neighbourAddress");
            String nPhoneNumber = getArguments().getString("neighbourPhoneNumber");
            String nAboutMe = getArguments().getString("neighbourAboutMe");
            String nAvatarURL = getArguments().getString("neighbourAvatarURL");
            String nSocialLink = getArguments().getString("neighbourSocialLink");

            // set the name to the textView
            headerNeighbourName.setText(nName);
            cardNeighbourName.setText(nName);
            cardNeighbourAddress.setText(nAdress);
            cardNeighbourPhoneNumber.setText(nPhoneNumber);
            cardNeighbourAboutMe.setText(nAboutMe);
            cardNeighbourSocialLink.setText(nSocialLink);

            Glide.with(headerAvatar.getContext())
                    .load(nAvatarURL)
                    .into(headerAvatar);
        }

        // return view
        return view;
    }
}