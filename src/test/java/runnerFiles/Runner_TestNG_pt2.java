package runnerFiles;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = "src/test/resources/featureFiles",
		glue = {"stepDefinitions", "com.bdd.bootcamp.pt2.hooks"},
		tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegister or @TutorialsNinjaLogout or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddToCart",
		plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
		)

public class Runner_TestNG_pt2 extends AbstractTestNGCucumberTests{
	
}
