package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byCssSelector
import org.openqa.selenium.By

class SideBarMenu : BasePage<SideBarMenu>() {
    override val uniqueLocator: By = byClassName("Layout_logo__FBH86")

//    private val logoImg = byClassName("Layout_logo__FBH86")

    private val homeBtn = byCssSelector("a[href='/']")
    private val campaignsBtn = byCssSelector("a[href='/campaigns']")
    private val charactersBtn = byCssSelector("a[href='/characters']")

    private val manualsBtn = byCssSelector("a[href='/manuals']")
    private val suscriptionsBtn = byCssSelector("a[href='/suscription']")
    private val addBtn = byCssSelector("img[alt='Add']")
    private val userImage = byClassName("Layout_userImage__BQE2e")

    fun clickHomeBtn() : HomePage {
        click(homeBtn)
        return HomePage().waitForPageLoad()
    }

    fun clickCampaignsBtn() : CampaignsPage {
        click(campaignsBtn)
        return CampaignsPage().waitForPageLoad()
    }

    fun clickCharactersBtn() : CharactersPage {
        click(charactersBtn)
        return CharactersPage().waitForPageLoad()
    }

    fun clickManualsBtn() : ManualsPage {
        click(manualsBtn)
        return ManualsPage().waitForPageLoad()
    }

    fun clickSuscriptionsBtn() : SuscriptionsPage {
        click(suscriptionsBtn)
        return SuscriptionsPage().waitForPageLoad()
    }

    fun clickAddBtn() {
        click(addBtn)
    }

    fun clickUserImage() {
        click(userImage)
    }
}