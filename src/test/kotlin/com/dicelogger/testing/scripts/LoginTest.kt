package com.dicelogger.testing.scripts

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import com.dicelogger.testing.pages.LandingPage
import com.dicelogger.testing.utils.Constants
import com.dicelogger.testing.utils.UtilMethods
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LoginTest {
    private val landingPage = LandingPage()
    companion object {
        @JvmStatic
        @BeforeAll
        fun setUpAll() {
            Configuration.browserSize = "1920x1080"
            SelenideLogger.addListener("allure", AllureSelenide())
        }
    }

    @BeforeEach
    fun setUpTest() {
        UtilMethods.setUp()
    }

    @ParameterizedTest @Tag("smoke") @Tag("login")
    @MethodSource("com.dicelogger.testing.dataProviders.Data#loginData")
    fun successfulLogin(email: String, password: String) {
//        val homePage = landingPage.login(email, password)
//        assertEquals(Constants.BASE_URL, homePage.getPageUrl(), "The current URL is not the expected one")
//        assertEquals(Constants.EXPECTED_HOMEPAGE_TITLE, homePage.getTitle(), "The current title is not the expected one")
//        UtilMethods.takeScreenshotAndAttachToAllure("Login successful")
    }
}