package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*

class CampaignsPage : BasePage() {
    private val pageTitle = byClassName("List_title__GNB9k")
    private val newCampaignBtn = byId("Mis campañas")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickNewCampaignBtn(): NewCampaignPage {
        clickSvgObjectWithJs(newCampaignBtn)
        return NewCampaignPage()
    }
}