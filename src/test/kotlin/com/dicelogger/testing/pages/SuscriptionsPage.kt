package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors.*
import org.openqa.selenium.By

class SuscriptionsPage : BasePage<SuscriptionsPage>() {
    override val uniqueLocator: By = byId("a")

}