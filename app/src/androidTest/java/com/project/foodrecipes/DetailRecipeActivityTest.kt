package com.project.foodrecipes

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.project.foodrecipes.activities.DetailRecipeActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailRecipeActivityTest {

    @Test
    fun testActivityComponents() {
        // Launch the activity
        val scenario = ActivityScenario.launch(DetailRecipeActivity::class.java)

        // Check if the title text matches
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))

        // Click the favorite button
        onView(withId(R.id.imgFavorite)).perform(click())

        // Check if a toast message is displayed
        onView(withText("Feature under development")).check(matches(isDisplayed()))

        // Close the activity
        scenario.close()
    }
}