package com.dicelogger.testing.pages

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By

class NewCampaignPage : BasePage<NewCampaignPage>() {
    override val uniqueLocator: By = Selectors.byId("nameCampaign")

    private val pageTitle = Selectors.byClassName("NewLayout_header__vpog2")
    private val titleField = Selectors.byId("nameCampaign")
    private val descriptionField = Selectors.byId("description")
    private val uploadMainImageBtn = Selectors.byName("image")
//    private val uploadMainImageBtn = Selectors.byCssSelector(".ImageInput_imageInput__kdc7C input[type='file']")
    private val uploadImagesBtn = Selectors.byName("extraImages")
    private val createCampaignBtn = Selectors.byCssSelector("button[type='submit']")

    override fun getTitle(): String {
        return getText(pageTitle)
    }

    fun getTitleField(): String {
        val field = Selectors.byId("nameCampaign")
        return getText(field)
    }

    fun getDescriptionField(): String {
        val field = Selectors.byId("description")
        return getText(field)
    }

    fun writeTitle(title: String) {
        sendText(title, titleField)
//        setValueWithJs(title, titleField)
    }

    fun writeDescription(description: String) {
        sendText(description, descriptionField)
//        setValueWithJs(description, descriptionField)
    }

    fun uploadMainImage(image: String) {
        uploadFile(image, uploadMainImageBtn)
    }

    fun uploadImages(images: List<String>) {
        images.forEach { uploadFile(it, uploadImagesBtn) }
    }

    fun clickCreateCampaignBtn() : CampaignDetailPage {
        click(createCampaignBtn)
        return CampaignDetailPage().waitForPageLoad()
    }

    fun fillCampaignData(title: String, description: String, mainImage: String, images: List<String>){
        writeTitle(title)
        writeDescription(description)
        uploadMainImage(mainImage)
        uploadImages(images)
    }
}