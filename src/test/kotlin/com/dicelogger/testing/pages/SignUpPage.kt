package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import org.openqa.selenium.By

class SignUpPage : BasePage<SignUpPage>() {
    override val uniqueLocator: By = byId("displayname")

    private val pageTitle = byCssSelector(".AuthForm_sectionAuth__EZb5Y h1")
    private val userName = byId("username")
    private val displayName = byId("displayname")
    private val email = byId("email")
    private val password = byId("password")
    private val submitBtn = byCssSelector(".Button_button__W_5Ku")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun enterUsername(username: String) {
        sendText(username, this.userName)
    }

    fun enterDisplayname(name: String) {
        sendText(name, this.displayName)
    }

    fun enterEmail(email: String) {
        sendText(email, this.email)
    }

    fun enterPassword(password: String) {
        sendText(password, this.password)
    }

    fun clickSubmitBtn(): HomePage {
        click(submitBtn)
        return HomePage().waitForPageLoad()
    }

    fun fillForm(username: String, displayname: String, email: String, password: String): HomePage {
        enterUsername(username)
        enterDisplayname(displayname)
        enterEmail(email)
        enterPassword(password)
        return clickSubmitBtn()
    }
}