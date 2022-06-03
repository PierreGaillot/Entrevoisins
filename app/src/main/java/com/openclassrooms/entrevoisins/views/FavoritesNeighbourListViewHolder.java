package com.openclassrooms.entrevoisins.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;




public class FavoritesNeighbourListViewHolder extends RecyclerView.ViewHolder {

    // Binds
    @BindView(R.id.item_list_name)
    TextView mNameTextView;
    // TODO ADD IMAGE bind & DELETE BTN bind
    @BindView(R.id.item_list_avatar)
    public ImageView mAvatarImageView;
    @BindView(R.id.item_list_delete_button)
    public ImageButton mDeleteButton;

    public FavoritesNeighbourListViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithNeighbour(Neighbour neighbour){
        this.mNameTextView.setText(neighbour.getName());
    }

}
