package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import org.openqa.selenium.By

class CampaignsPage : BasePage<CampaignsPage>() {
    override val uniqueLocator: By = byId("Mis campañas")

    private val pageTitle = byClassName("List_title__GNB9k")
    private val newCampaignBtn = byId("Mis campañas")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickNewCampaignBtn(): NewCampaignPage {
        clickSvgObjectWithJs(newCampaignBtn)
        return NewCampaignPage().waitForPageLoad()
    }
}