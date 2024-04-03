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
        landingPage.login("8il.andre@gmail.com", "Password123")
    }

    @ParameterizedTest
//    @Tag("smoke")
    @Tag("campaign")
    @MethodSource("com.dicelogger.testing.dataProviders.Data#campaignData")
    fun createCampaign(title: String, description: String, mainImage: String, images: List<String>) {
        val campaignsPage = sidebar.clickCampaignsBtn()
        assertEquals(Constants.CAMPAIGNS_URL, campaignsPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_CAMPAIGNS_TITLE, campaignsPage.getTitle(), "The current title is not the expected one")

        val campaignTemplatesPage = campaignsPage.clickNewCampaignBtn()
        assertEquals(Constants.CAMPAIGN_TEMPLATES_URL, campaignTemplatesPage.getPageUrl(), "The current URL is not the expected one")
//        assertEquals(Constants.EXPECTED_NEW_CAMPAIGN_TITLE, campaignTemplatesPage.getTitle(), "The current title is not the expected one")

        val newCampaignPage = campaignTemplatesPage.clickCreateFromZeroBtn()
        assertEquals(Constants.NEW_CAMPAIGN_URL, campaignTemplatesPage.getPageUrl(), "The current URL is not the expected one")
//        assertEquals(Constants.EXPECTED_NEW_CAMPAIGN_TITLE, campaignTemplatesPage.getTitle(), "The current title")

        newCampaignPage.fillCampaignData(title, description, mainImage, images)
        UtilMethods.takeScreenshotAndAttachToAllure("Campaign data filled")
//        assertEquals(title, newCampaignPage.getTitleField(), "The title is not the expected one")
//        assertEquals(description, newCampaignPage.getDescriptionField(), "The description is not the expected one")

        val campaignDetailPage = newCampaignPage.clickCreateCampaignBtn()
        assertEquals("Golinjam", campaignDetailPage.getTitle(), "The current title is not the expected one")
        UtilMethods.takeScreenshotAndAttachToAllure("Should show the new campaign")
    }

    @ParameterizedTest
//    @Tag("smoke")
    @Tag("character")
    @MethodSource("com.dicelogger.testing.dataProviders.Data#characterData")
    fun createCharacter() {
        val charactersPage = sidebar.clickCharactersBtn()
        assertEquals(Constants.CHARACTERS_URL, charactersPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_CHARACTERS_TITLE, charactersPage.getTitle(), "The current title is not the expected one")

        val newCharacterPage = charactersPage.clickNewCharacterBtn()
        assertEquals(Constants.NEW_CHARACTERS_URL, newCharacterPage.getPageUrl(), "The current URL is not the expected one")

    }

    @Test
    fun readManuals() {
        val manualsPage = sidebar.clickManualsBtn()
        assertEquals(Constants.MANUALS_URL, manualsPage.getPageUrl(), "The current URL is not the expected one")
        assertEquals(Constants.EXPECTED_MANUALS_TITLE, manualsPage.getTitle(), "The current title is not the expected one")

    }
}