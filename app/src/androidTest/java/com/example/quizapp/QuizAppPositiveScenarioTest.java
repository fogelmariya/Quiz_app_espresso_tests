package com.example.quizapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class QuizAppPositiveScenarioTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testPositiveQuizScenario() {
        // Assume there's a question with options and a submit button in the app
        onView(withId(R.id.question_input)).perform(typeText("Correct Answer"));
        onView(withId(R.id.submit_button)).perform(click());
        
        // Check if the result view shows the expected success message
        onView(withId(R.id.result_view)).check(matches(withText("Congratulations! You got it right.")));
    }
}