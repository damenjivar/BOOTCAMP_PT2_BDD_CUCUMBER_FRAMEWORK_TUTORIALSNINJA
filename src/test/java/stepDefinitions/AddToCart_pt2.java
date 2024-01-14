package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bdd.bootcamp.pt2.pages.HomePage;
import com.bdd.bootcamp.pt2.pages.SearchPage;
import com.bdd.bootcamp.pt2.pages.ValidProductPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart_pt2 {

	public WebDriver driver;
	public HomePage homepage;
	public Properties dataProp;
	public SearchPage searchpage;
	public ValidProductPage validproductpage;

	@Given("the user opens the application")
	public void the_user_opens_the_application() {
		driver = DriverFactory_pt2.getDriver();
	}

	@When("the user enters valid product {string} in the search bar")
	public void the_user_enters_valid_product_in_the_search_bar(String validProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(validProductText);
	}

	@And("clicks on the search button")
	public void clicks_on_the_search_button() {
		searchpage = homepage.clickOnSearchButton();
	}

	@Then("the user gets valid product info display in SearchPage")
	public void the_user_gets_valid_product_info_display_in_searchpage() {
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
	}

	@When("the user clicks on the valid product")
	public void the_user_clicks_on_the_valid_product() {
		validproductpage = searchpage.clickOnValidProduct();
	}

	@And("clicks the add to cart button")
	public void clicks_the_add_to_cart_button() {
		validproductpage.clickOnAddToCartButton();
	}
}