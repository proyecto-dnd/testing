package com.dicelogger.testing.pages

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.StaleElementReferenceException
import java.time.Duration

abstract class BasePage<T : BasePage<T>> {
    abstract val uniqueLocator: By
    private val pageTitle = byCssSelector("h2")

    fun getPageUrl(): String {
        return WebDriverRunner.getWebDriver().currentUrl
    }

    open fun getTitle(): String {
        return getText(pageTitle)
    }

    open fun waitForPageLoad(): T {
        `$`(uniqueLocator).shouldBe(visible, Duration.ofSeconds(10))
        return this as T
    }

    open fun waitForPageLoad(uniqueLocator: By): T {
        `$`(uniqueLocator).shouldBe(visible, Duration.ofSeconds(10))
        return this as T
    }

    fun sendText(text: String, locator: By) {
        val element = `$`(locator).shouldBe(visible).shouldBe(enabled)
        element.click()
        val osName = System.getProperty("os.name").lowercase()
        val selectAll = if (osName.contains("mac")) Keys.chord(Keys.COMMAND, "a") else Keys.chord(Keys.CONTROL, "a")

        element.sendKeys(selectAll, text)
    }

    fun setValueWithJs(text: String, locator: By) {
        val webElement = `$`(locator).should(exist).toWebElement()
        try {
            executeJavaScript<Unit>("arguments[0].value=arguments[1];", webElement, text)
        } catch (e: Exception) {
            throw RuntimeException("Error setting value with JS", e)
        }
    }

    fun click(locator: By) {
        val element = `$`(locator).shouldBe(visible, Duration.ofSeconds(10)).shouldBe(enabled)
        try {
            element.click()
        } catch (e: StaleElementReferenceException) {
            element.click()
        }
    }

    fun getText(locator: By): String {
        return `$`(locator).shouldBe(visible).text
    }

    fun uploadFile(filePath: String, locator: By) {
        `$`(locator).shouldBe(visible).uploadFromClasspath(filePath)
    }

    fun clickSvgObjectWithJs(locator: By) {
        val svgObject = `$`(locator).should(exist)
        try {
            executeJavaScript<Unit>("arguments[0].click();", svgObject)
        } catch (e: Exception) {
            throw RuntimeException("Error clicking SVG object with JS", e)
        }
    }
}