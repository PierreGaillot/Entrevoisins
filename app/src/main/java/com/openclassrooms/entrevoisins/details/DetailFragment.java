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
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.ToggleFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


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
            initFavBntColor(nIsFavorite);
        }



        // Set on clickListener on fav Btn
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ToggleFavoriteNeighbourEvent(getArguments().getLong("neighbourId")));
                initFavBntColor(getArguments().getBoolean("neighbourIsFavorite"));
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


    //
    // TEST EVENT
    //

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    /**
     * Toggle to favorite Event
     * it was a test to create an event
     */
    @Subscribe
        public void toggleNeighbourToFavorite(ToggleFavoriteNeighbourEvent toggleEvent){
        initFavBntColor(getArguments().getBoolean("neighbourIsFavorite"));
    }
}