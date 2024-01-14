package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = "src/test/resources/featureFiles",
		glue = {"stepDefinitions", "com.bdd.bootcamp.pt2.hooks"},
		tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegister or @TutorialsNinjaSearchProduct",
		plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
		)

public class Runner_JUnit_pt2 {

}