package com.example.ruimartins.propertyworld;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ruimartins.propertyworld.dagger.AppComponent;
import com.example.ruimartins.propertyworld.dagger.mock.DaggerAppComponentMock;
import com.example.ruimartins.propertyworld.dagger.mock.NetworkModuleMock;
import com.example.ruimartins.propertyworld.ui.PropertyActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class GetLocationTest {

    @Rule public ActivityTestRule<PropertyActivity> propertyActivityActivityTestRule = new ActivityTestRule<PropertyActivity>(PropertyActivity.class) {

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

    @Test
    public void getLocation() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withText("In… Porto, Portugal")).check(matches(withParent(withId(R.id.toolbar))));
    }
}
