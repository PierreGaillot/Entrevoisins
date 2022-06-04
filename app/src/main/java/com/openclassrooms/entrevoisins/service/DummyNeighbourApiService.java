package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    /**
     * @return List<FavoriteNeighbours>
     */
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        ArrayList<Neighbour> favoritesNeighbours;
        favoritesNeighbours = new ArrayList<>();
        for (Neighbour n: neighbours
             ) {
            if (n.getFavorite() == true){
                favoritesNeighbours.add(n);
            }
        }
        return favoritesNeighbours;
    }


    /**
     * Return the neighbour by id
     * @param id
     * @return neighbour
     */
    public Neighbour getNeighbourById(long id){
        Neighbour neighbour = null;
        for (Neighbour n: neighbours
        ) {
            if (n.getId() == id){
                neighbour = n;
            }
        }
        return neighbour;
    }


}
