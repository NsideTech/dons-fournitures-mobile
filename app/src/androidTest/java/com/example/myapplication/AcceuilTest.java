package com.example.myapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AcceuilTest {

    private Context context;

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new
            ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {

        mActivityTestRule.getScenario().onActivity(activity -> context = activity.getApplicationContext());
    }

    @Test
    public void AcceuilValide() {

        //valeur du nombre de recherche dans notre Api
        int count = 1;
        String expectedText = "Aujourd'hui, nous avons " + count + " demandes de fournitures.";
        onView(withId(R.id.txtAcceuilAppli)).check(matches(withText(expectedText)));
        onView(withId(R.id.btnContribuer)).perform(ViewActions.click());
    }
}
