package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class ToggleFavoriteNeighbourEvent {

    /**
     * Neighbour favorite toggle
     */
    public Neighbour neighbour;
    public NeighbourApiService mNeighbourApiService  = DI.getNeighbourApiService();


    /**
     * Constructor.
     * @param neighbourId
     */
    public ToggleFavoriteNeighbourEvent(long neighbourId) {
        this.neighbour = mNeighbourApiService.getNeighbourById(neighbourId);
        neighbour.toggleFavorite();
    }

}
