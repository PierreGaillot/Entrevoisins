package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);


    /**
     * getFavoritesNeighbour
     * @return {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Return the neighbour by id
     * @param id
     * @return neighbour
     */
    Neighbour getNeighbourById(long id);


//    /**
//     * Toggle to favorite
//     * @param neighbour
//     */
//    void toggleFavorite(Neighbour neighbour);
}
