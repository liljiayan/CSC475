@file:Suppress("DEPRECATION")

package com.project.foodrecipes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.project.foodrecipes.activities.FilterFoodActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilterFoodActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(FilterFoodActivity::class.java)

    @Test
    fun testActivityComponents() {
        // Check if the title text matches
        onView(withId(R.id.tvTitle)).check(matches(withText("Food List")))

        // Click the back button in the toolbar
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click())

        // Check if the activity is finished after clicking the back button
        assert(activityRule.activity.isFinishing)
    }
}
