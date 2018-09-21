package com.example.ruimartins.propertyworld;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import com.example.ruimartins.propertyworld.dagger.AppComponent;
import com.example.ruimartins.propertyworld.dagger.mock.DaggerAppComponentMock;
import com.example.ruimartins.propertyworld.dagger.mock.NetworkModuleMock;
import com.example.ruimartins.propertyworld.ui.PropertyActivity;
import com.example.ruimartins.propertyworld.ui.PropertyDetails;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class OpenActivityOnClickTest {


    @Rule
    public ActivityTestRule<PropertyActivity> propertyActivityActivityTestRule = new IntentsTestRule<PropertyActivity>(PropertyActivity.class) {
        @Override
        protected void beforeActivityLaunched() {

            PropertyWorldApplication application = (PropertyWorldApplication) InstrumentationRegistry
                    .getInstrumentation()
                    .getTargetContext()
                    .getApplicationContext();
            AppComponent component = DaggerAppComponentMock
                    .builder()
                    .networkModuleMock(new NetworkModuleMock())
                    .build();
            application.setAppComponent(component);
        }
    };


    // Check if clicking on RecyclerView item opens Details Activity and Intent data passed
    @Test
    public void recyclerItemClick_OpensDetailsActivity() {
        onView(withId(R.id.properties))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(0, click()));

        intended(hasComponent(PropertyDetails.class.getName()));

        onView(withText("Some Hostel")).check(matches(isDisplayed()));
    }
}
