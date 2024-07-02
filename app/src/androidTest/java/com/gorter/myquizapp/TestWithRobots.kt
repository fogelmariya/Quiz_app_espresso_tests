package com.gorter.quizAppEspresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gorter.myquizapp.MainActivity
import com.gorter.myquizapp.R
import com.gorter.quizAppEspresso.robots.main
import com.gorter.quizAppEspresso.robots.quizQuestions
import com.gorter.quizAppEspresso.robots.result
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestWithRobots {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun canEnterName() {
        onView(withId(R.id.et_name)).perform(typeText("Mariia"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.tv_question)).check(matches(isDisplayed()))
    }

    @Test
    fun canEnterNameAndSeeNextScreen() {
        main {
            enterName("Mariia")
            pressStart()
        }
        quizQuestions {
            isOnQuestionsScreen()
        }
    }

    @Test
    fun allAnswersCorrectTest() {
        val name = "Mariia"
        main {
            enterName(name)
            pressStart()
        }
        quizQuestions {
            isOnQuestionsScreen()
            answerAllCorrectly()
        }
        result {
            isOnResultScreen()
            nameIsShown(name)
            resultIsXOutOfTen(10)
        }
    }

    @Test
    fun withIncorrectAnswerPossibleGoToNextQuestion(){
        val name = "Mariia"
        main {
            enterName(name)
            pressStart()
        }
        quizQuestions {
            isOnQuestionsScreen()
            selectAnswer(2)
            clickSubmit()
            goToNextQuestion()
            checkProgressBar(2)
        }
    }
}