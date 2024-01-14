package com.bdd.bootcamp.pt2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextbox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextbox;

	@FindBy(id = "input-email")
	private WebElement emailTextbox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextbox;

	@FindBy(id = "input-password")
	private WebElement passwordTextbox;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsLetterYesRadioButton;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password confirmation does not match password!')]")
	private WebElement passwordMismatchWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retrievePasswordMismatchWarningMessage() {
		String passwordmismatchwarningmessage = passwordMismatchWarningMessage.getText();
		return passwordmismatchwarningmessage;
	}

	public String retrievePasswordWarningMessage() {
		String passwordwarningmessage = passwordWarningMessage.getText();
		return passwordwarningmessage;
	}

	public String retrieveTelephoneWarningMessage() {
		String telephonewarningmessage = telephoneWarningMessage.getText();
		return telephonewarningmessage;
	}

	public String retrieveEmailWarningMessage() {
		String emailwarningmessage = emailWarningMessage.getText();
		return emailwarningmessage;
	}

	public String retrieveLastNameWarningMessage() {
		String lastnamewarningmessage = lastNameWarningMessage.getText();
		return lastnamewarningmessage;
	}

	public String retrieveFirstNameWarningMessage() {
		String firstnamewarningmessage = firstNameWarningMessage.getText();
		return firstnamewarningmessage;
	}

	public String retrievePrivacyPolicyWarningMessage() {
		String privacypolicywarningmessage = privacyPolicyWarningMessage.getText();
		return privacypolicywarningmessage;
	}

	public void enterMandatoryDetails(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}
	
	public void enterAllDetails(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}
	
	public void enterAllDetailsWithExistingEmail(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}
	
	public void enterAllDetailsWithMismatchPassword(String firstNameText, String lastNameText, String emailText, String telephoneText,
			String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameTextbox.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameTextbox.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailTextbox.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneTextbox.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordTextbox.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}

	public void clickOnNewsLetterYesRadioButton() {
		newsLetterYesRadioButton.click();
	}

	public void clickOnPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public String retrieveDuplicateEmailWarningMessage() {
		String emailDuplicateWarningMessage = duplicateEmailWarningMessage.getText();
		return emailDuplicateWarningMessage;
	}
}