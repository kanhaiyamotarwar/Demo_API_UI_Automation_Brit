package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:target/report/cucumber.html","rerun:rerun/failed_scenario.txt"},
                 features= {"@rerun/failed_scenario.txt"},
                 glue= {"StepDefinations"},
                 tags= ("@API_Sanity or @UI_Sanity")
                
		)
public class Rerunner {

}
