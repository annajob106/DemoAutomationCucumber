package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "feature"//path of feature file
 ,glue={"step_definition"}, //path of step definition file,
 monochrome = true,//display the console output in readable format
 dryRun = false
)
 

public class TestRunner {

}
