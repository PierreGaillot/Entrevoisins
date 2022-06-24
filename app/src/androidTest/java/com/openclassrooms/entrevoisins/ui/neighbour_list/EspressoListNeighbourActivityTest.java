package com.openclassrooms.entrevoisins.ui.neighbour_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.AllOf.allOf;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.openclassrooms.entrevoisins.R;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoListNeighbourActivityTest {


    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    /**
     * TextView display the correct neighbourName to detailActivity
     */
    @Test
    public void espressoListNeighbourActivityTest() {

        // 1 positionInList => Generate INT between 0 > neighbourListSize ?
        int positionInList = 0;

        // 2 Get the neighbour object from position in list
        // Neighbour neighbourTested =

        // 3 get this neighbour name to check
        String neighbourName = "Caroline";

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list_neighbours),
                        withParent(withId(R.id.container))));
        recyclerView.perform(actionOnItemAtPosition(positionInList, click()));
        ViewInteraction textView = onView(
                allOf(withId(R.id.detailNeighbourHeaderNameTextView), withText(neighbourName),
                        withParent(allOf(withId(R.id.navigation_header_container),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))),
                        isDisplayed()));
        textView.check(matches(withText(neighbourName)));
    }

}
/** FIX ERROR from my coworker Léa ! */
//cccccccccccccccccccccc
