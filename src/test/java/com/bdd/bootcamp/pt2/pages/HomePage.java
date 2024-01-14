package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchTextbox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy(xpath = "//h3[text() = 'Featured']")
	private WebElement featuredText;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage goToLoginPage() {
		myAccountDropDown.click();
		loginOption.click();
		return new LoginPage(driver);
	}

	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}

	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductDetail(String productNameText) {
		searchTextbox.sendKeys(productNameText);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public boolean verifyDisplayStatusOfFeaturedText() {
		boolean presenceOfFeaturedText = featuredText.isDisplayed();
		return presenceOfFeaturedText;
	}
}