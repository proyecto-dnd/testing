package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors

class NewCampaignPage : BasePage() {
    private val pageTitle = Selectors.byClassName("NewLayout_header__vpog2")
    private val titleField = Selectors.byId("nameCampaign")
    private val descriptionField = Selectors.byId("description")
    private val uploadMainImageBtn = Selectors.byName("image")
    private val uploadImagesBtn = Selectors.byName("extraImages")
    private val createCampaignBtn = Selectors.byCssSelector("button[type='submit']")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun writeTitle(title: String) {
        setValueWithJs(title, titleField)
    }

    fun writeDescription(description: String) {
        setValueWithJs(description, descriptionField)
    }

    fun uploadMainImage(image: String) {
        uploadFile(image, uploadMainImageBtn)
    }

    fun uploadImages(images: List<String>) {
        images.forEach { uploadFile(it, uploadImagesBtn) }
    }

    fun createCampaign(title: String, description: String, mainImage: String, images: List<String>) {
        writeTitle(title)
        writeDescription(description)
        uploadMainImage(mainImage)
        uploadImages(images)
        click(createCampaignBtn)
    }
}