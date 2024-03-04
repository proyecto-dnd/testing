package com.dicelogger.testing.scripts

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import com.dicelogger.testing.pages.LandingPage
import com.dicelogger.testing.utils.Constants
import com.dicelogger.testing.utils.UtilMethods
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.chrome.ChromeOptions

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

    @ParameterizedTest
    @MethodSource("com.dicelogger.testing.dataProviders.Data#loginData")
    fun successfulLogin(email: String, password: String) {
        val homePage = landingPage.login(email, password)
        Thread.sleep(1000)
        assertEquals(Constants.BASE_URL, homePage.getPageUrl(), "The current URL is not the expected one")
        UtilMethods.takeScreenshotAndAttachToAllure("Login successful")
    }
}