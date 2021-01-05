package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sbaru\\eclipse-workspace\\JulyAugBDD\\src\\main\\java\\features",
							glue="step_defination",
							plugin= {"pretty","html:target/DemoTours-reports"},
							monochrome=true)
public class TestRunner {

}
