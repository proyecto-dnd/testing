package com.dicelogger.testing.pages

import org.openqa.selenium.By

class LandingPage : BasePage<LandingPage>() {
    override val uniqueLocator: By = By.linkText("¡COMIENZA TU AVENTURA!")

    private val pageTitle = By.cssSelector(".Hero_hero__w9KoE h2")
    private val pageLogo = By.xpath("body > main > section.Hero_wrapper__EBHHK.section > section > div > div > svg > path")

    private val loginBtn = By.className("LoginPopup_button__AQ071")
    private val emailField = By.id("email")
    private val passwordField = By.id("password")
    private val passwordToggleVisibilityBtn = By.cssSelector(".Input_passwordButton__5e2mK")
    private val loginSubmitButton = By.className("LoginPopup_submit__PS8Sm")
    private val selectOptionBtn = By.cssSelector(".LoginPopup_popup__BUFYE .Input_input__kHzex")
    private val loginDescription = By.id("description")
    private val loginRegisterBtn = By.linkText("Regístrate")

    private val pageSubtitle = By.cssSelector(".Hero_hero__S_es6 h2")
    private val pageText = By.cssSelector(".Hero_hero__S_es6 p")
    private val signUpBtn = By.linkText("¡COMIENZA TU AVENTURA!")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickSignUpBtn(): SignUpPage {
        click(signUpBtn)
        return SignUpPage().waitForPageLoad()
    }

    fun enterEmail(name: String) {
        sendText(name, emailField)
    }

    fun enterPassword(pwd: String) {
        sendText(pwd, passwordField)
    }

    fun login(email: String, password: String) : HomePage {
        click(loginBtn)
        enterEmail(email)
        enterPassword(password)
        click(loginSubmitButton)
        return HomePage().waitForPageLoad()
    }
}
