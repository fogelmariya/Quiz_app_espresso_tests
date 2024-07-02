package com.gorter.quizAppEspresso.robots

import com.gorter.myquizapp.R


fun main(func: MainActivityRobot.() -> Unit) =
    MainActivityRobot().apply{ func() }
class MainActivityRobot : BaseTestRobot() {

    fun enterName(name: String) {
        enterTextOnViewWithId(R.id.et_name, name)
    }

    fun pressStart(){
        clickViewWithId(R.id.btn_start)
    }

    fun titleIsShown(){
        viewWithIdIsDisplayed(androidx.core.R.id.title)
    }
}