package com.dicelogger.testing.pages

import org.openqa.selenium.By

class HomePage : BasePage<HomePage>() {
    override val uniqueLocator: By = By.cssSelector(".Home_home__GWOui h2")

    private val pageTitle = By.cssSelector(".Home_home__GWOui h2")

    override fun getTitle(): String {
        return getText(pageTitle)
    }
}