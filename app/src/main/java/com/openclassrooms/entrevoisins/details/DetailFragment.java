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
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


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
            Neighbour currentNeighbour = (Neighbour) getArguments().getSerializable("currentNeighbour");

            String nName = currentNeighbour.getName();
            String nAddress = currentNeighbour.getAddress();
            String nPhoneNumber = currentNeighbour.getPhoneNumber();
            String nAboutMe = currentNeighbour.getAboutMe();
            String nAvatarURL = currentNeighbour.getAvatarUrl();
            String nSocialLink = currentNeighbour.getSocialLink();
            Boolean nIsFavorite = currentNeighbour.getFavorite();
            long nId = currentNeighbour.getId();


            // set Sting data to textViews
            headerNeighbourName.setText(nName);
            cardNeighbourName.setText(nName);
            cardNeighbourAddress.setText(nAddress);
            cardNeighbourPhoneNumber.setText(nPhoneNumber);
            cardNeighbourAboutMe.setText(nAboutMe);
            cardNeighbourSocialLink.setText(nSocialLink);
            // set avatar to ImageView
            Glide.with(headerAvatar.getContext())
                    .load(nAvatarURL)
                    .into(headerAvatar);


            // set favorite Button color display
            initFavBntColor(nIsFavorite);
        }



        // Set on clickListener on fav Btn
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Neighbour currentNeighbour = (Neighbour) getArguments().getSerializable("currentNeighbour");
                NeighbourApiService mNeighbourApiService  = DI.getNeighbourApiService();
                // Toggle this instance of current neighbour
                mNeighbourApiService.toggleFavorite(currentNeighbour);
                initFavBntColor(((Neighbour) getArguments().getSerializable("currentNeighbour")).getFavorite());
                // Toggle neighbour in list
                mNeighbourApiService.toggleFavorite(mNeighbourApiService.getNeighbourById(currentNeighbour.getId()));
            }
        });
        // return view
        return view;
    }

    /**
     * initialize Favorite button color
     * @param1 isFav
     */
    private void initFavBntColor(Boolean isFav) {
        if (isFav){
            this.favButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowFav)));
            this.favButton.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightWhite)));
        } else {
            this.favButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightWhite)));
            this.favButton.setSupportImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowFav)));
        }
    }

}