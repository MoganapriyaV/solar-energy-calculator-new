package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/solarEnergyCalculator.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-Report.html" }
)
public class SolarEnergyCalculatorRun extends AbstractTestNGCucumberTests {
}
