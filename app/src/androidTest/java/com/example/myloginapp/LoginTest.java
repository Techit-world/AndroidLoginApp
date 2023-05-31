package com.example.myloginapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    private View decorView;
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

     @Test
    public void loginTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.username),
                          isDisplayed()));
        appCompatEditText.perform(replaceText("demo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("demo"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.loginbtn), withText("LOGIN"),
                        isDisplayed()));
        materialButton.perform(click());
        onView(withId(R.id.sName)).check(matches(withText("LOGIN SUCCESSFUL!!")));
     }

    @Test
    public void invalidLoginTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.username),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("demo1"), closeSoftKeyboard());
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                         isDisplayed()));
        appCompatEditText2.perform(replaceText("demo1"), closeSoftKeyboard());
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.loginbtn), withText("LOGIN"),
                        isDisplayed()));
        materialButton.perform(click());
        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.sName),isDisplayed()));
        onView(withId(R.id.sName)).check(matches(withText("LOGIN FAILED!!")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
