package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class ToggleFavoriteNeighbourEvent {

    /**
     * Neighbour favorite toggle
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbourId
     */
    public ToggleFavoriteNeighbourEvent(long neighbourId) {
        this.neighbour = neighbour;
    }

}
