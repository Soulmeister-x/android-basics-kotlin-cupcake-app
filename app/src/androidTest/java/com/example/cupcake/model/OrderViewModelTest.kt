package com.example.cupcake.model

import androidx.fragment.app.testing.FragmentScenario
import com.example.cupcake.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cupcake.StartFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OrderViewModelTest {

    private lateinit var navController: TestNavHostController
    private lateinit var startFragmentScenario: FragmentScenario<StartFragment>


    @Before
    fun setup() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        startFragmentScenario = launchFragmentInContainer<StartFragment>(themeResId = R.style.Theme_AppCompat)

        startFragmentScenario.onFragment { fragmemt ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragmemt.requireView(), navController)
        }

    }

    @Test
    fun testStartup() {
        launchFragmentInContainer<StartFragment>()
        // create fragment instance -> in @Before ?
        // assert that the correct options are displayed
        //onView(withText("Order Cupcakes")).check(isDisplayed())
    }

    @Test
    fun testPriceOneCupcake() {
        // create a new instance of the StartFragment
        //val startFragment = StartFragment()

        // isolate fragment in container
        val scenario = launchFragmentInContainer<StartFragment>()

        // navigate to next screen by choosing one cupcake option
        onView(withId(R.id.order_one_cupcake)).perform(click())

        // check if correct subtotal is displayed
        onView(withSubstring("$5")).check(matches(isDisplayed()))


    }


    // TODO: write tests
    // fun testPriceSixCupcakes ()

    // fun testPriceTwelveCupcakes()

    // fun testPriceOneCupcakeWithoutSameDayPickup
    // 1. create instance of the StartFragment
    // 2. click OneCupcake option
    // 3. click Next - choose vanilla flavor
    // 4. choose tomorrow as PickUp date
    // 5. check if correct subtotal is displayed

}