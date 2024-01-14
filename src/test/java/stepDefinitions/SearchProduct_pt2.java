package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bdd.bootcamp.pt2.pages.HomePage;
import com.bdd.bootcamp.pt2.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct_pt2 {

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory_pt2.getDriver();
	}

	@When("User enters the valid product {string}")
	public void user_enters_the_valid_product(String validProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(validProductText);
	}

	@And("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
		homepage = new HomePage(driver);
		searchpage = homepage.clickOnSearchButton();
	}

	@Then("User gets valid product info display in SearchPage")
	public void user_gets_valid_product_info_display_in_searchpage() {
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
	}

	@When("User enters the invalid product {string}")
	public void user_enters_the_invalid_product(String invalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(invalidProductText);
	}

	@Then("User gets no product match warning message")
	public void user_gets_no_product_match_warning_message() {
		Assert.assertTrue(searchpage.verifyDisplayStatusOfInvalidProductWarningMessage());
	}
}