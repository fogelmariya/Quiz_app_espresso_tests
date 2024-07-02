package com.gorter.quizAppEspresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.gorter.myquizapp.ResultActivity
import org.junit.Rule
import org.junit.Test

class ResultScreenTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(ResultActivity::class.java)

    @Test
    fun titleIsShown() {
        onView(ViewMatchers.withText("Result"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}