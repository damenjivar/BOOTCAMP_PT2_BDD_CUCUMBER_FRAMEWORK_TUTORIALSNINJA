package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidProductPage {

	public WebDriver driver;

	@FindBy(css = "#button-cart.btn.btn-primary.btn-lg.btn-block")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement addedToCartSuccessMessage;

	public ValidProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public String retrieveAddedToCartSuccessMessage() {
		String addedtocartsuccessmessage = addedToCartSuccessMessage.getText();
		return addedtocartsuccessmessage;
	}
}