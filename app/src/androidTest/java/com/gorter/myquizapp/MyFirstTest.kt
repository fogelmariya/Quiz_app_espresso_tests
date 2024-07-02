package com.gorter.myquizapp

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyFirstTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun titleIsShown() {
        onView(withText("Quiz App!")).check(matches(isDisplayed()))
    }

    @Test
    fun canEnterName() {
        onView(withId(R.id.et_name)).perform(typeText("Mariia"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.tv_question)).check(matches(isDisplayed()))
    }

    fun enterTextOnViewWithId(@IdRes viewId: Int, text: String) {
        onView(withId(viewId)).perform(typeText(text))
        closeSoftKeyboard()
    }
    fun clickViewWithId(@IdRes viewId: Int) {
        onView(withId(viewId))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun viewWithIdIsDisplayed(@IdRes viewId: Int) {
        onView(withId(viewId))
            .check(matches(isDisplayed()))
    }
}