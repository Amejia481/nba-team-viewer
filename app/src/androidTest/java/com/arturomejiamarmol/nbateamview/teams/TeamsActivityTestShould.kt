package com.arturomejiamarmol.nbateamview.teams

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TeamsActivityTestShould {

  @get:Rule
  val activity = ActivityTestRule<TeamsActivity>(TeamsActivity::class.java)

  @Test
  fun displayListOfTeams() {

    onView(withText("Boston Celtics"))
        .check(matches(isDisplayed()))
  }

  @Test
  fun displayDetailsTeams() {

    onView(withText("Boston Celtics"))
        .perform(click())

    onView(withText("Boston Celtics"))
        .check(matches(isDisplayed()))

    onView(withText("45"))
        .check(matches(isDisplayed()))

    onView(withText("20"))
        .check(matches(isDisplayed()))
  }


}