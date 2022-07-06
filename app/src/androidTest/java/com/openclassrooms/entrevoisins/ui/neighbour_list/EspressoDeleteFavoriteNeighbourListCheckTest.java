package com.openclassrooms.entrevoisins.ui.neighbour_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoDeleteFavoriteNeighbourListCheckTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    /**
     * Check Delete favorite neighbour in the favoriteNeighboursList
     * remove him from the display of the list
     */

    @Test
    public void espressoDeleteFavoriteNeighbourListCheckTest() {

        NeighbourApiService service = DI.getNeighbourApiService();
        int favNeighbourListSize = service.getFavoriteNeighbours().size();

        // Generate random number from the favoriteNeighbour size.
        int positionInList = new Random().nextInt(service.getFavoriteNeighbours().size()-1);


        // Swipe to favorite tab
        ViewInteraction viewPager = onView(ViewMatchers.withId(R.id.container));
                viewPager.perform(swipeLeft());
        // Given : Check The FavoriteNeighboursList size
        onView(ViewMatchers.withId(R.id.list_favorite_neighbours)).check(withItemCount(favNeighbourListSize));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_favorite_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionInList, new DeleteViewAction()));
        // Check if the number of FavoriteNeighboursList is -1
        onView(ViewMatchers.withId(R.id.list_favorite_neighbours)).check(withItemCount(favNeighbourListSize-1));
    }

}
