package com.bdd.bootcamp.pt2.hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.bdd.bootcamp.pt2.driverLogic.DriverFactory_pt2;
import com.bootcamp.pt2.bdd.utilities.Bootcamp_ConfigReader;
import com.bootcamp.pt2.bdd.utilities.Util;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class MyHooks_pt2 {

	public WebDriver driver;
	public Properties prop;

	@Before
	public void setUp() throws Exception {
		prop = Bootcamp_ConfigReader.initializeConfigPropertiesFile();
		DriverFactory_pt2.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory_pt2.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@BeforeStep(order = 1)
	public void checksBeforeEachStepPriority1() {
		System.out.println("Checking before every step if everything is working fine or not - Prioritized 1");
	}

	@BeforeStep(order = 2)
	public void checksBeforeEachStepPriority2() {
		System.out.println("Checking before every step if everything is working fine or not - Prioritized 2");
	}

	@AfterStep(order = 2)
	public void checksAfterEachStepPriority1() {
		System.out.println("Checking after every step if everything is working fine or not - Prioritized 1");
	}

	@AfterStep(order = 1)
	public void checksAfterEachStepPriority2() {
		System.out.println("Checking after every step if everything is working fine or not - Prioritized 2");
	}
}