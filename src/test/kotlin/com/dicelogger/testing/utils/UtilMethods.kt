package com.dicelogger.testing.utils

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Allure
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File
import java.io.FileInputStream

class UtilMethods {
    companion object {
        fun setUp() {
            Selenide.open("about:blank")
            WebDriverRunner.getWebDriver().manage().deleteAllCookies()
//        Selenide.executeJavaScript<Unit>("window.localStorage.clear();")
            Configuration.browserCapabilities = ChromeOptions().addArguments("--remote-allow-origins=*")
            Selenide.open(Constants.LANDING_URL)
        }

        fun getRandomString(length: Int): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

        fun getRandomUsername(): String {
            return getRandomString(8)
        }

        fun getRandomEmail(): String {
            return "${getRandomString(10)}@gmail.com"
        }

        fun takeScreenshotAndAttachToAllure(name: String) {
            val screenshotPath = Selenide.screenshot(name)
            val screenshotFile = File(screenshotPath)
            if (screenshotFile.exists()) {
                Allure.addAttachment(name, FileInputStream(screenshotFile))
            }
        }
    }
}