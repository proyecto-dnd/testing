package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import org.openqa.selenium.By

class CampaignTemplatesPage : BasePage<CampaignTemplatesPage>(){
    override val uniqueLocator: By = byClassName("Button_button__W_5Ku")

    private val pageTitle = byCssSelector("NewLayout_header__vpog2 h2")
    private val creatFromZeroBtn = byClassName("Button_button__W_5Ku")
    private val campaignsBtn = byCssSelector("a[href='/campaigns/new']")
    private val useTemplate1Btn = byXpath("/html/body/main/section[2]/section/form/section[2]/div[2]/div/a[1]")
    private val useTemplate3Btn = byXpath("/html/body/main/section[2]/section/form/section[2]/div[2]/div/a[3]")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickCreateFromZeroBtn(): NewCampaignPage {
        click(creatFromZeroBtn)
        return NewCampaignPage().waitForPageLoad()
    }
}