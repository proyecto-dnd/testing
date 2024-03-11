package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selectors.byId
import org.openqa.selenium.By

class CharactersPage : BasePage<CharactersPage>() {
    override val uniqueLocator: By = byId("Mis personajes")

    private val pageTitle = Selectors.byClassName("List_title__GNB9k")
    private val newCharacterBtn = byId("Mis personajes")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickNewCharacterBtn(): NewCharacterPage {
        clickSvgObjectWithJs(newCharacterBtn)
        return NewCharacterPage().waitForPageLoad()
    }
}