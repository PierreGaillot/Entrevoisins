


package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createNeighbourWithSuccess(){
        Neighbour newNeighbour = new Neighbour(999, "Jean Michel Test", "https://i.pravatar.cc/150?u=00306","13 rue rubens, 59800 Lille", "06 63 47 69 96", "J'adore le formage", false);
        service.createNeighbour(newNeighbour);
        assertTrue(service.getNeighbours().contains(newNeighbour));
    }

    @Test
    public void toggleFavoriteNeighbourWithSuccess(){
        Neighbour testNeighbour = service.getNeighbours().get(0);
        Boolean isFavNeighbour = testNeighbour.getFavorite();
        service.toggleFavorite(testNeighbour);
        assertFalse(testNeighbour.getFavorite() == isFavNeighbour);
    }

    @Test
    public void getNeighbourByIdWithSuccess(){
        long testId = 1;
        Neighbour testNeighbour = service.getNeighbourById(testId);
        assertFalse(testNeighbour.getId() != testId);
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        List<Neighbour> favoriteNeighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        int favNeighbourCount = 0;
        for (Neighbour n: expectedNeighbours) {
            if(n.getFavorite()){
                favNeighbourCount ++;
            }
        } assertTrue(favNeighbourCount == favoriteNeighbours.size());
    }

}
