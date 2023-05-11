package TestRunnerAPI;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		 features= {"src/test/resources/APIFeatureFiles"},
		 glue= {"apiStepDefinition"},
		 tags = "@tagapi",
		 plugin= {"pretty"},
		 publish=true
)
public class TestRunnerAPI extends AbstractTestNGCucumberTests{
	
	

}
