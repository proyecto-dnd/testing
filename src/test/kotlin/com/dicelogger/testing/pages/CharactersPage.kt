package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selectors.byId

class CharactersPage : BasePage() {
    private val pageTitle = Selectors.byClassName("List_title__GNB9k")
    private val newCharacterBtn = byId("Mis personajes")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun clickNewCharacterBtn(): NewCharacterPage {
        clickSvgObjectWithJs(newCharacterBtn)
        return NewCharacterPage()
    }
}