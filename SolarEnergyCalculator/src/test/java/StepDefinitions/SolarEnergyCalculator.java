package StepDefinitions;

import PageObjectModel.SolarEnergyCalculatorPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SolarEnergyCalculator {
    public WebDriver driver;
    public SolarEnergyCalculatorPageObjects solarEnergyCalculatorPageObjects;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        solarEnergyCalculatorPageObjects = new SolarEnergyCalculatorPageObjects(driver);
    }

    @Given("Launching solar energy calculator site {string}")
    public void launching_solar_energy_calculator(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("Entering postcode {string}")
    public void entering_postcode(String postcode) {
        solarEnergyCalculatorPageObjects.enterPostcode(postcode);
    }

    @Then("Trying to enter the calculator page by clicking next button and verify the invalid postcode is detected")
    public void trying_enter_the_calculator_page_by_clicking_next_button() {
        solarEnergyCalculatorPageObjects.enterIntoSolarCalculator()
                .postcodeValidation();
    }

    @Then("Entering into the calculator page by clicking next button")
    public void entering_into_the_calculator_page_by_clicking_next_button() {
        solarEnergyCalculatorPageObjects.enterIntoSolarCalculator();
    }

    @And("Selecting roof slope {int} degree")
    public void selecting_roof_slope(int slope) {
        solarEnergyCalculatorPageObjects.selectingRoofSlope(slope);
    }

    @And("Selecting shading {int} percentage")
    public void selecting_shading_percentage(int shade) {
        solarEnergyCalculatorPageObjects.selectingShadingValue(shade);
    }

    @And("Selecting installation size {string}")
    public void selecting_installation_size(String string) {
        solarEnergyCalculatorPageObjects.selectingInstallationSize(string);
    }

    @And("Reaching result page by clicking the next button")
    public void checking_result_by_clicking_the_next_button() {
        solarEnergyCalculatorPageObjects.gettingResultPage();
    }

    @Then("Checking for {string} page and taking screenshot")
    public void checking_Potential_annual_benefit(String string) {
        solarEnergyCalculatorPageObjects.checkingAnnualBenefit(string);
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshotByte = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotByte, "image/png", "Result page screenshot attached");
    }

    @After(order = 0)
    public void close() {
        driver.quit();
    }

}
