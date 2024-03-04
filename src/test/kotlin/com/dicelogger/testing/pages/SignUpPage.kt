package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selectors.byId

class SignUpPage : BasePage() {
    private val pageTitle = byCssSelector(".SignUpForm_h1__6W_up")
    private val name = byId("name")
    private val lastname = byId("lastName")
    private val username = byId("user")
    private val email = byId("email")
    private val password = byId("password")
    private val repeatPassword = byId("repitPassword")
    private val submitBtn = byCssSelector(".Button_button__W_5Ku")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun enterName(name: String) {
        sendText(name, this.name)
    }

    fun enterLastName(lastname: String) {
        sendText(lastname, this.lastname)
    }

    fun enterUsername(username: String) {
        sendText(username, this.username)
    }

    fun enterEmail(email: String) {
        sendText(email, this.email)
    }

    fun enterPassword(password: String) {
        sendText(password, this.password)
    }

    fun enterRepeatPassword(repeatPassword: String) {
        sendText(repeatPassword, this.repeatPassword)
    }

    fun clickSubmitBtn(): LandingPage {
        click(submitBtn)
        return LandingPage()
    }

    fun fillForm(name: String, lastname: String, username: String, email: String, password: String, repeatPassword: String): LandingPage {
        enterName(name)
        enterLastName(lastname)
        enterUsername(username)
        enterEmail(email)
        enterPassword(password)
        enterRepeatPassword(repeatPassword)
        return clickSubmitBtn()
    }
}