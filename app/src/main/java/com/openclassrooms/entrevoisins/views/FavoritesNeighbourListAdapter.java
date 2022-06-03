package com.openclassrooms.entrevoisins.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public class FavoritesNeighbourListAdapter extends RecyclerView.Adapter<FavoritesNeighbourListViewHolder> {


    // DATA (List to display)
    private List<Neighbour> favoritesNeighbours;

    // Adapter Constructor
    public FavoritesNeighbourListAdapter(List<Neighbour> favoritesNeighbours) {
        this.favoritesNeighbours = favoritesNeighbours;
    }


    @NonNull
    @Override
    public FavoritesNeighbourListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create viewHolder and inflating its XML layout
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_neighbour, viewGroup, false);
        return new FavoritesNeighbourListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesNeighbourListViewHolder viewHolder, int position) {
        viewHolder.updateWithNeighbour(this.favoritesNeighbours.get(position));
    }

    @Override
    public int getItemCount() {
        return this.favoritesNeighbours.size();
    }
}
