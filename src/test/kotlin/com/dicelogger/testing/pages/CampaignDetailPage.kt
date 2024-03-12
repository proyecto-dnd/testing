package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By

class CampaignDetailPage : BasePage<CampaignDetailPage>() {
    override val uniqueLocator: By = Selectors.byClassName("page_button__ecUMy")

    private val pageTitle = Selectors.byCssSelector("NewLayout_header__vpog2 h2")
    private val startGameBtn = Selectors.byClassName("page_button__ecUMy")

    override fun getTitle(): String {
        return getText(pageTitle)
    }
}