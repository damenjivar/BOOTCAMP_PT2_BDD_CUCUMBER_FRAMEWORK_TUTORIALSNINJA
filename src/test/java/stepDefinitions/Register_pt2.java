package stepDefinitions;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bdd.bootcamp.pt2.pages.AccountSuccessPage;
import com.bdd.bootcamp.pt2.pages.HomePage;
import com.bdd.bootcamp.pt2.pages.LoginPage;
import com.bdd.bootcamp.pt2.pages.RegisterPage;
import com.bootcamp.pt2.bdd.utilities.Bootcamp_DataPropReader;
import com.bootcamp.pt2.bdd.utilities.Util;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_pt2 {

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public Map<String, String> dataMap;
	public AccountSuccessPage accountsuccesspage;
	public Properties dataProp;

	@Given("User navigates to RegisterPage")
	public void user_navigates_to_register_page() {
		driver = DriverFactory_pt2.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.clickOnRegisterOption();
	}

	@When("User enters below mandatory fields")
	public void user_enters_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		registerpage.enterMandatoryDetails(dataMap.get("firstname"), dataMap.get("lastname"),
				Util.emailWithDateTimeStamp(), dataMap.get("telephone"), dataMap.get("password"),
				dataMap.get("confirmpassword"));
	}

	@When("User enters below all fields")
	public void user_enters_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		registerpage.enterAllDetails(dataMap.get("firstname"), dataMap.get("lastname"), Util.emailWithDateTimeStamp(),
				dataMap.get("telephone"), dataMap.get("password"), dataMap.get("confirmpassword"));
	}

	@When("User enters below all fields with existing email")
	public void user_enters_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		registerpage.enterAllDetailsWithExistingEmail(dataMap.get("firstname"), dataMap.get("lastname"),
				dataMap.get("email"), dataMap.get("telephone"), dataMap.get("password"),
				dataMap.get("confirmpassword"));
	}

	@When("User enters below all fields with mismatch password")
	public void user_enters_below_all_fields_with_mismatch_password(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		registerpage.enterAllDetailsWithMismatchPassword(dataMap.get("firstname"), dataMap.get("lastname"),
				Util.emailWithDateTimeStamp(), dataMap.get("telephone"), dataMap.get("password"),
				dataMap.get("confirmpassword"));
	}

	@When("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.clickOnNewsLetterYesRadioButton();
	}

	@When("User selects PrivacyPolicy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		registerpage.clickOnPrivacyPolicyCheckbox();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountsuccesspage = registerpage.clickOnContinueButton();
	}

	@Then("User account gets created successfully")
	public void user_account_gets_created_successfully() {
		Assert.assertTrue(accountsuccesspage.verifyDisplayStatusOfAccountSuccessMessage());
	}

	@Then("User gets duplicate email warning message")
	public void user_gets_duplicate_email_warning_message() throws Exception {
		dataProp = Bootcamp_DataPropReader.initializeDataPropPropertiesFile();
		Assert.assertTrue(registerpage.retrieveDuplicateEmailWarningMessage()
				.contains(dataProp.getProperty("expectedExistingEmailWarningMessage")));
	}

	@Then("User gets warning message for mandatory fields")
	public void user_gets_warning_message_for_mandatory_fields() throws Exception {
		dataProp = Bootcamp_DataPropReader.initializeDataPropPropertiesFile();
		Assert.assertTrue(registerpage.retrievePrivacyPolicyWarningMessage()
				.contains(dataProp.getProperty("expectedPrivacyPolicyWarningMessage")));

		Assert.assertTrue(registerpage.retrieveFirstNameWarningMessage()
				.contains(dataProp.getProperty("expectedFirstNameWarningMessage")));

		Assert.assertTrue(registerpage.retrieveLastNameWarningMessage()
				.contains(dataProp.getProperty("expectedLastNameWarningMessage")));

		Assert.assertTrue(registerpage.retrieveEmailWarningMessage()
				.contains(dataProp.getProperty("expectedEmailWarningMessage")));

		Assert.assertTrue(registerpage.retrieveTelephoneWarningMessage()
				.contains(dataProp.getProperty("expectedTelephoneWarningMessage")));

		Assert.assertTrue(registerpage.retrievePasswordWarningMessage()
				.contains(dataProp.getProperty("expectedPasswordWarningMessage")));
	}

	@Then("User gets password mismatch warning message")
	public void user_gets_password_mismatch_warning_message() throws Exception {
		dataProp = Bootcamp_DataPropReader.initializeDataPropPropertiesFile();
		Assert.assertTrue(registerpage.retrievePasswordMismatchWarningMessage()
				.contains(dataProp.getProperty("expectedMismatchPasswordWarningMessage")));
	}
}