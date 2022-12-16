package com.example.cupcake.model

import com.example.cupcake.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cupcake.StartFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OrderViewModelTest {

    @Test
    fun testPriceOneCupcake() {
        // create a new instance of the StartFragment
        val startFragment = StartFragment()

        // add fragment to a new activity

        val scenario = launchFragmentInContainer<StartFragment>()

        onView(withId(R.id.order_one_cupcake)).perform(click())
        onView(withSubstring("$5.00")).check(matches(isDisplayed()))

    }
}