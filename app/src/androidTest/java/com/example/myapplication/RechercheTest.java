package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.FragmentManager;
import android.content.Context;


import androidx.fragment.app.Fragment;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import com.example.myapplication.fragment.RechercheFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

@RunWith(AndroidJUnit4.class)
public class RechercheTest {

    private Context context;
    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new
            ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void setUp() throws IllegalAccessException, InstantiationException {


        mActivityTestRule.getScenario().onActivity(activity -> {
            context = activity.getApplicationContext();
            fragmentManager = activity.getFragmentManager();
        } );

    }

    @Test
    public void NameValide(){

        onView(withId(R.id.txtTitreSearch)).check(matches(withText("Je Recherche")));
        onView(withId(R.id.editTextNomRecherche)).perform(ViewActions.typeText("jacky"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextPhoneRecherche)).perform(ViewActions.typeText("111-111-1111"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextEmailRecherche)).perform(ViewActions.typeText("jacky@gmail.com"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextPaysRecherche)).perform(ViewActions.typeText("canada"),
                closeSoftKeyboard());
        onView(withId(R.id.edtDescriptionRecherche)).perform(ViewActions.typeText("calculatrice"),
                closeSoftKeyboard());
        onView(withId(R.id.btnSoumettreSearch)).perform(ViewActions.click());

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.hasObject(By.text(context.getString(R.string.information_valide)));
    }
}
