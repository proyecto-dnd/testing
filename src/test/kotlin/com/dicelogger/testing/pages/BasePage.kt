package com.dicelogger.testing.pages

import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.By
import org.openqa.selenium.Keys

open class BasePage {
    private val pageTitle = byCssSelector("h2")

    fun getPageUrl(): String {
        return WebDriverRunner.getWebDriver().currentUrl
    }

    open fun getTitle(): String {
        return getText(pageTitle)
    }

    fun findElement(locator: By) = `$`(locator)

    fun getElements(locator: By) = `$$`(locator)

    fun sendText(text: String, locator: By) {
        val element = `$`(locator).shouldBe(visible).shouldBe(enabled)
        val existingValue = element.`val`()
        element.click()
        if (existingValue != null) {
            repeat(existingValue.length) {
                element.sendKeys(Keys.BACK_SPACE)
            }
        }
        element.sendKeys(text)
    }

    fun setValueWithJs(text: String, locator: By) {
        val webElement = `$`(locator).toWebElement()
        executeJavaScript<Unit>("arguments[0].value=arguments[1];", webElement, text)
    }

    fun click(locator: By) {
        `$`(locator).shouldBe(visible).shouldBe(enabled).click()
    }

    fun getText(locator: By): String {
        return `$`(locator).shouldBe(visible).shouldBe(enabled).text
    }

    fun uploadFile(filePath: String, locator: By) {
        `$`(locator).uploadFromClasspath(filePath)
    }

    fun clickSvgObjectWithJs(locator: By) {
        val svgObject = `$`(locator)
        executeJavaScript<Unit>("arguments[0].click();", svgObject)
    }
}