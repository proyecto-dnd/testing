package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import com.dicelogger.testing.utils.Constants
import org.openqa.selenium.By

class ManualsPage : BasePage<ManualsPage>() {
    override val uniqueLocator: By = byCssSelector("a[href='${Constants.PLAYER_MANUAL_URL}']")

    private val pageTitle = byCssSelector(".page_title__i1bMk h2")

    private val playerManual = byCssSelector("a[href='${Constants.PLAYER_MANUAL_URL}']")
    private val masterManual = byCssSelector("a[href='${Constants.MASTER_MANUAL_URL}']")
    private val monsterManual = byCssSelector("a[href='${Constants.MONSTER_MANUAL_URL}']")

    override fun getTitle(): String {
        return getText(pageTitle)
    }
}