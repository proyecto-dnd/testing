//package com.dicelogger.testing.scripts
//
//import com.codeborne.selenide.Condition.attribute
//import com.codeborne.selenide.Condition.visible
//import com.codeborne.selenide.Configuration
//import com.codeborne.selenide.Selenide
//import com.codeborne.selenide.Selenide.element
//import com.codeborne.selenide.Selenide.open
//import org.openqa.selenium.chrome.ChromeOptions
//import com.codeborne.selenide.logevents.SelenideLogger
//import com.dicelogger.testing.pages.MainPageExample
//import io.qameta.allure.selenide.AllureSelenide
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.*
//
//class LandingPageExampleTest {
//    private val mainPageExample = MainPageExample()
//    companion object {
//      @BeforeAll            fun setUpAll() {
//          Configuration.browserSize = "1280x800"
//                         SelenideLogger.addListener("allure", AllureSelenide())
//            }
//    }
//
//    @BeforeEach        fun setUp() {
//        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
//        Configuration.browserCapabilities = ChromeOptions().addArguments("--remote-allow-origins=*")
//        open("https://www.jetbrains.com/")
//    }
//
//    @Test
//    fun search() {
//        mainPageExample.searchButton.click()
//
//        element("[data-test='search-input']").sendKeys("Selenium")
//        element("button[data-test='full-search-button']").click()
//
//        element("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"))
//    }
//
//    @Test
//    fun toolsMenu() {
//        mainPageExample.toolsMenu.click()
//
//        element("div[data-test='main-submenu']").shouldBe(visible)
//    }
//
//    @Test
//    fun navigationToAllTools() {
//        mainPageExample.seeDeveloperToolsButton.click()
//        mainPageExample.findYourToolsButton.click()
//
//        element("#products-page").shouldBe(visible)
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title())            }
//}
