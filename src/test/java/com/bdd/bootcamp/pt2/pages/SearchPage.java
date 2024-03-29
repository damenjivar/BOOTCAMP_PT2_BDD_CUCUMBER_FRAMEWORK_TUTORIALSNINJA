package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;

	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;

	@FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
	private WebElement invalidProductWarningMessage;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfValidProduct() {
		boolean presenceOfValidProduct = validProduct.isDisplayed();
		return presenceOfValidProduct;
	}

	public boolean verifyDisplayStatusOfInvalidProductWarningMessage() {
		boolean presenceOfInvalidProductWarningMessage = invalidProductWarningMessage.isDisplayed();
		return presenceOfInvalidProductWarningMessage;
	}
	
	public ValidProductPage clickOnValidProduct() {
		validProduct.click();
		return new ValidProductPage(driver);
	}
}