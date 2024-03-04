package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byCssSelector

class SideBarMenu : BasePage() {
    private val logoImg = byClassName("Layout_logo__FBH86")

    private val homeBtn = byCssSelector("a[href='/']")
    private val campaignsBtn = byCssSelector("a[href='/campaigns']")
    private val charactersBtn = byCssSelector("a[href='/characters']")

    private val manualsBtn = byCssSelector("a[href='/manuals']")
    private val suscriptionsBtn = byCssSelector("a[href='/suscription']")
    private val addBtn = byCssSelector("img[alt='Add']")
    private val userImage = byClassName("Layout_userImage__BQE2e")

    fun clickHomeBtn() : HomePage {
        click(homeBtn)
        return HomePage()
    }

    fun clickCampaignsBtn() : CampaignsPage {
        click(campaignsBtn)
        return CampaignsPage()
    }

    fun clickCharactersBtn() : CharactersPage {
        click(charactersBtn)
        return CharactersPage()
    }

    fun clickManualsBtn() : ManualsPage {
        click(manualsBtn)
        return ManualsPage()
    }

    fun clickSuscriptionsBtn() : SuscriptionsPage {
        click(suscriptionsBtn)
        return SuscriptionsPage()
    }

    fun clickAddBtn() {
        click(addBtn)
    }

    fun clickUserImage() {
        click(userImage)
    }
}