package com.dicelogger.testing.scripts

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.logevents.SelenideLogger
import com.dicelogger.testing.pages.LandingPage
import com.dicelogger.testing.pages.SideBarMenu
import com.dicelogger.testing.utils.Constants
import com.dicelogger.testing.utils.UtilMethods
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.chrome.ChromeOptions

class SideBarTest {
    private val landingPage = LandingPage()
    private val sidebar = SideBarMenu()
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
//        Selenide.open(Constants.LANDING_URL)
//        Configuration.headless = false
//        Configuration.holdBrowserOpen = true
        landingPage.login("tester@gmail.com", "Password123")
    }

    @ParameterizedTest @Tag("smoke") @Tag("campaign")
    @MethodSource("com.dicelogger.testing.dataProviders.Data#campaignData")
    fun createCampaign(title: String, description: String, mainImage: String, images: List<String>) {
        val campaignsPage = sidebar.clickCampaignsBtn()
        Thread.sleep(3000)
        assertEquals(Constants.CAMPAIGNS_URL, campaignsPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_CAMPAIGNS_TITLE, campaignsPage.getTitle(), "The current title is not the expected one")

        val newCampaignPage = campaignsPage.clickNewCampaignBtn()
        Thread.sleep(1000)
        assertEquals(Constants.NEW_CAMPAIGN_URL, newCampaignPage.getPageUrl(), "The current URL is not the expected one")

        newCampaignPage.createCampaign(title, description, mainImage, images)
        Thread.sleep(1000)
        UtilMethods.takeScreenshotAndAttachToAllure("Should show the new campaign")
//        assertEquals(title, newCampaignPage.getText(Selectors.byId("nameCampaign")), "The title is not the expected one")
    }

    @ParameterizedTest @Tag("smoke") @Tag("character")
    @MethodSource("com.dicelogger.testing.dataProviders.Data#characterData")
    fun createCharacter() {
        val charactersPage = sidebar.clickCharactersBtn()
        Thread.sleep(1000)
        assertEquals(Constants.CHARACTERS_URL, charactersPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_CHARACTERS_TITLE, charactersPage.getTitle(), "The current title is not the expected one")

        val newCharacterPage = charactersPage.clickNewCharacterBtn()
        Thread.sleep(1000)
        assertEquals(Constants.NEW_CHARACTERS_URL, newCharacterPage.getPageUrl(), "The current URL is not the expected one")


    }

    @Test
    fun readManuals() {
        val manualsPage = sidebar.clickManualsBtn()
        Thread.sleep(1000)
        assertEquals(Constants.MANUALS_URL, manualsPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_MANUALS_TITLE, manualsPage.getTitle(), "The current title is not the expected one")

    }
}