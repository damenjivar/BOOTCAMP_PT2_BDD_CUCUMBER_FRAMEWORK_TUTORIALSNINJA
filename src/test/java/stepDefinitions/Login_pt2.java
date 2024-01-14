package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bdd.bootcamp.pt2.pages.AccountPage;
import com.bdd.bootcamp.pt2.pages.HomePage;
import com.bdd.bootcamp.pt2.pages.LoginPage;
import com.bootcamp.pt2.bdd.utilities.Bootcamp_DataPropReader;
import com.bootcamp.pt2.bdd.utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_pt2 {

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataProp;

	@Given("^User ([a-zA-Z]{1,}) to LoginPage$")
	public void user_navigates_to_loginpage(String navigationMode) {
		driver = DriverFactory_pt2.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.clickOnLoginOption();
	}

	@When("^User enters valid email (.+) into email textbox field$")
	public void user_enters_valid_email(String validEmailText) {
		loginpage.enterEmail(validEmailText);
	}

	@And("^User enters valid password (.+) into password textbox field$")
	public void user_enters_valid_password(String validPasswordText) {
		loginpage.enterPassword(validPasswordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountpage = loginpage.clickOnLoginButton();
	}

	@Then("User is navigated to AccountPage")
	public void user_is_navigated_to_accountpage() {
		Assert.assertTrue(accountpage.validateDisplayStatusOfEditAccountInfoLink());
	}

	@When("User enters invalid email")
	public void user_enters_invalid_email() {
		loginpage.enterEmail(Util.emailWithDateTimeStamp());
	}

	@And("User enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
	}

	@Then("User gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() throws Exception {
		dataProp = Bootcamp_DataPropReader.initializeDataPropPropertiesFile();
		Assert.assertTrue(loginpage.retrieveCredentialsMismatchWarningMessage()
				.contains(dataProp.getProperty("expectedNoMatchEmailPasswordWarningMessage")));
	}
}