package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import org.openqa.selenium.By

class NewCharacterPage : BasePage<NewCharacterPage>() {
    override val uniqueLocator: By = byId("age")

}