package com.asuper.maptest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ChangeInstrumentedTest {

    String cloud = "40%";
    String temperature = "20" + "\u00b0" + "C";

    @Rule
    public ActivityTestRule<MapsActivity> mMapsActivityActivityTestRule =
            new ActivityTestRule<MapsActivity>(MapsActivity.class);

    @Test
    public void changeWeather_updatesUI() throws Exception{
        onView(withId(R.id.mCloudButton))
                .perform(click());
        onView(withId(R.id.mWeatherText))
                .check(matches(withText(cloud)));
        onView(withId(R.id.mTemperatureButton))
                .perform(click());
        onView(withId(R.id.mWeatherText))
                .check(matches(withText(temperature)));
    }

}

