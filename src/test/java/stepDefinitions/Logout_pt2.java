package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bdd.bootcamp.pt2.pages.AccountPage;
import com.bdd.bootcamp.pt2.pages.HomePage;
import com.bdd.bootcamp.pt2.pages.LoginPage;
import com.bdd.bootcamp.pt2.pages.LogoutPage;
import com.bootcamp.pt2.bdd.utilities.Bootcamp_ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_pt2 {

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public Properties prop;
	public Properties dataProp;
	public AccountPage accountpage;
	public LogoutPage logoutpage;

	@Given("the user is logged into the application")
	public void the_user_is_logged_into_the_application() throws Exception {
		driver = DriverFactory_pt2.getDriver();
		homepage = new HomePage(driver);
		loginpage = homepage.goToLoginPage();
		prop = Bootcamp_ConfigReader.initializeConfigPropertiesFile();
		accountpage = loginpage.enterLoginCredentials(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
	}

	@When("the user clicks on the Logout button")
	public void the_user_clicks_on_the_logout_button() {
		logoutpage = accountpage.clickOnLogoutButton();
	}

	@Then("the user should be redirected to the logout page")
	public void the_user_should_be_redirected_to_the_logout_page() {
		Assert.assertTrue(logoutpage.verifyDisplayStatusOfAccountLogoutText());
	}

	@Then("a confirmation message should be displayed")
	public void a_confirmation_message_should_be_displayed() {
		Assert.assertTrue(logoutpage.verifyDisplayStatusOfLogoutSuccessMessage());
	}

	@When("the user clicks on the Continue button")
	public void the_user_clicks_on_the_continue_button() {
		homepage = logoutpage.clickOnContinueButton();
	}
	
	@Then("the user should be redirected to the home page")
	public void the_user_should_be_redirected_to_the_home_page() {
		Assert.assertTrue(homepage.verifyDisplayStatusOfFeaturedText());
	}
}
