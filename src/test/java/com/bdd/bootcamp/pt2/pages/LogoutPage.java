package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//p[contains(text(), 'You have been logged off your account. It is now safe to leave the computer.')]")
	private WebElement logoutSuccessMessage;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement logoutContinueButton;
	
	@FindBy(xpath = "//h1[text() = 'Account Logout']")
	private WebElement accountLogoutText;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDisplayStatusOfLogoutSuccessMessage() {
		boolean presenceOfLogoutSuccessMessage = logoutSuccessMessage.isDisplayed();
		return presenceOfLogoutSuccessMessage;
	}
	
	public HomePage clickOnContinueButton() {
		logoutContinueButton.click();
		return new HomePage(driver);
	}
	
	public boolean verifyDisplayStatusOfAccountLogoutText() {
		boolean accountlogouttext = accountLogoutText.isDisplayed();
		return accountlogouttext;
	}
}