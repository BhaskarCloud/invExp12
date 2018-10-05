package lpl.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",
				glue={"StepDefinition"})//,
				//tags= {"~@Second"})	// this will skip @Second tag scenario
public class TestRunner {

}
