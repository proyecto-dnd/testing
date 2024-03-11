package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import org.openqa.selenium.By

// page_url = https://proyecto-dnd.vercel.app/characters/new
class NewCharacterPage : BasePage<NewCharacterPage>() {
    override val uniqueLocator: By = byId("age")

}