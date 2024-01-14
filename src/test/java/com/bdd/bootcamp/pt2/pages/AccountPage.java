package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfoLink;

	@FindBy(xpath = "//div[@class = 'list-group']/a[text() = 'Logout']")
	private WebElement logoutButton;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateDisplayStatusOfEditAccountInfoLink() {
		boolean displayStatus = editAccountInfoLink.isDisplayed();
		return displayStatus;
	}

	public LogoutPage clickOnLogoutButton() {
		logoutButton.click();
		return new LogoutPage(driver);
	}
}