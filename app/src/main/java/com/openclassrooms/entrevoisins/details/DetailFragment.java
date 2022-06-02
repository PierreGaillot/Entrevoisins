package com.openclassrooms.entrevoisins.details;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;


public class DetailFragment extends Fragment {

    // initialize variable
    // > Neighbour Data
    ImageView headerAvatar;
    TextView headerNeighbourName;
    TextView cardNeighbourName;
    TextView cardNeighbourAddress;
    TextView cardNeighbourPhoneNumber;
    TextView cardNeighbourAboutMe;
    TextView cardNeighbourSocialLink;
    // > Fav Button
    FloatingActionButton favButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // initialize view
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // assign neighbour data Variables
        headerAvatar = view.findViewById(R.id.detailNeighbourAvatarImageView);
        headerNeighbourName = view.findViewById(R.id.detailNeighbourHeaderNameTextView);
        cardNeighbourName = view.findViewById(R.id.detailNeighbourCardNameTextView);
        cardNeighbourAddress = view.findViewById(R.id.detailNeighbourAdressTextView);
        cardNeighbourPhoneNumber = view.findViewById(R.id.detailNeighbourPhoneTextView);
        cardNeighbourAboutMe = view.findViewById(R.id.detailTextViewNeighbourAboutme);
        cardNeighbourSocialLink = view.findViewById(R.id.detailNeighbourSocialLinkTextView);
        // assign favorite Button
        favButton = view.findViewById(R.id.detailFavBtn);

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
            Boolean nIsFavorite = getArguments().getBoolean("neighbourIsFavorite");
            long nId = getArguments().getLong("neighbourId");


            // set Sting data to textViews
            headerNeighbourName.setText(nName);
            cardNeighbourName.setText(nName);
            cardNeighbourAddress.setText(nAdress);
            cardNeighbourPhoneNumber.setText(nPhoneNumber);
            cardNeighbourAboutMe.setText(nAboutMe);
            cardNeighbourSocialLink.setText(nSocialLink);
            // set avatar to ImageView
            Glide.with(headerAvatar.getContext())
                    .load(nAvatarURL)
                    .into(headerAvatar);

            // set favorite Button color display
            setFavBntColor(favButton, nIsFavorite);
        }

        //TEST
        // Set on clickListener on fav Btn
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Parcelable neighbour Test
//                Neighbour currentNeighbour = getArguments().getParcelable("neighbour");
//                currentNeighbour.toggleFavorite();

                setFavBntColor(favButton, getArguments().getBoolean("neighbourIsFavorite"));
            }
        });

        // return view
        return view;
    }


    /**
     * Toggle to favorite
     * @param1 favBtn
     * @param2 isFav
     */
    private void setFavBntColor(FloatingActionButton favBtn, Boolean isFav) {
        if (isFav){
            favBtn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowFav)));
            favBtn.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightWhite)));
        } else {
            favBtn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightWhite)));
            favBtn.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowFav)));
        }
    }
}