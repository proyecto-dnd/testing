package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*

// page_url = https://proyecto-dnd.vercel.app/manuals
class ManualsPage : BasePage() {
    private val pageTitle = byCssSelector(".page_title__i1bMk h2")

    override fun getTitle(): String {
        return getText(pageTitle)
    }
}