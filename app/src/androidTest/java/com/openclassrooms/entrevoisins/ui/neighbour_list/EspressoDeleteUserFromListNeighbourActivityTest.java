package com.openclassrooms.entrevoisins.ui.neighbour_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;

import static org.hamcrest.core.IsNull.notNullValue;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoDeleteUserFromListNeighbourActivityTest {

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);


    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * Test Delete User From the Neighbour recyclerView
     * 1 - Get the neighboursList size
     * 2 - delete a neighbour from the list
     * 3 - compare the list size
     */
    @Test
    public void espressoDeleteUserFromListNeighbourActivityTest() {

        NeighbourApiService service = DI.getNeighbourApiService();
        int favNeighbourListSize = service.getNeighbours().size();

        // Generate random number from the favoriteNeighbour size.
        int positionInList = new Random().nextInt(service.getNeighbours().size()-1);


        // Given : We remove the element at random position
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(favNeighbourListSize));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionInList, new DeleteViewAction()));
        // Then : the number of element is -1
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(favNeighbourListSize-1));
    }

}
