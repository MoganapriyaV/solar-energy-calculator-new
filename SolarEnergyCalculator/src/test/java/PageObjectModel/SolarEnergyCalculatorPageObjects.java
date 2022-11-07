package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SolarEnergyCalculatorPageObjects {

    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_strPostcode_Start")
    WebElement _postCodeField;
    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_btnNext_Start")
    WebElement _nextButtonOnPostCodeValidationPage;
    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_bltErrorList_Start")
    WebElement _errorMessagePopup;
    @FindBy(how = How.ID, using = "RadSliderDecrease_ctl00_ctl00_cphMainContent_cphPageWithSidebar_intRoofPitch")
    WebElement _roofSlopeDecrease;
    @FindBy(how = How.ID, using = "RadSliderIncrease_ctl00_ctl00_cphMainContent_cphPageWithSidebar_intRoofPitch")
    WebElement _roofSlopeIncrease;
    @FindBy(how = How.ID, using = "RadSliderDecrease_ctl00_ctl00_cphMainContent_cphPageWithSidebar_intOvershading")
    WebElement _shadeDecrease;
    @FindBy(how = How.ID, using = "RadSliderIncrease_ctl00_ctl00_cphMainContent_cphPageWithSidebar_intOvershading")
    WebElement _shadeIncrease;
    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_intGenerationID")
    WebElement _installationSizeDropDownOptions;
    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_btnNext_Quote")
    WebElement _nextButtonOnSolarCalculator;
    @FindBy(how = How.ID, using = "cphMainContent_cphPageWithSidebar_strResults_TotalAnnualBenefit")
    WebElement _totalAnnualBenefit;


    public WebDriver webDriver;

    public SolarEnergyCalculatorPageObjects(WebDriver _webDriver) {
        webDriver = _webDriver;
        PageFactory.initElements(_webDriver, this);

    }

    public SolarEnergyCalculatorPageObjects enterPostcode(String code) {
        _postCodeField.clear();
        _postCodeField.sendKeys(code);
        return this;
    }

    public SolarEnergyCalculatorPageObjects postcodeValidation() {
        Assert.assertTrue(_errorMessagePopup.isDisplayed());
        return this;
    }

    public SolarEnergyCalculatorPageObjects enterIntoSolarCalculator() {
        _nextButtonOnPostCodeValidationPage.click();
        return this;
    }


    public SolarEnergyCalculatorPageObjects selectingRoofSlope(int slope) {
        int defaultSlopeValue = 30;
        if (slope > defaultSlopeValue) {
            do {
                _roofSlopeIncrease.click();
                defaultSlopeValue += 5;
            }
            while (slope > defaultSlopeValue);
        }
        if (slope < defaultSlopeValue) {
            do {
                _roofSlopeDecrease.click();
                defaultSlopeValue -= 5;
            }
            while (slope < defaultSlopeValue);
        }
        return this;
    }

    public SolarEnergyCalculatorPageObjects selectingShadingValue(int shade) {
        int defaultMinValue = 20;
        int defaultMaxValue = 60;
        if (shade < defaultMinValue) {
            do {
                _shadeDecrease.click();
                defaultMinValue -= 20;
            }
            while (shade < defaultMinValue);
        }
        if (shade > defaultMaxValue) {
            do {
                _shadeIncrease.click();
                defaultMinValue += 20;
            }
            while (shade > defaultMinValue);
        }
        return this;
    }

    public SolarEnergyCalculatorPageObjects selectingInstallationSize(String size) {
        Select select = new Select(_installationSizeDropDownOptions);
        select.selectByVisibleText(size);
        return this;
    }

    public SolarEnergyCalculatorPageObjects gettingResultPage() {
        _nextButtonOnSolarCalculator.click();
        Assert.assertTrue(webDriver.getPageSource().contains("Your results"));
        return this;
    }

    public SolarEnergyCalculatorPageObjects checkingAnnualBenefit(String string) {
        List<WebElement> listOfResults = webDriver.findElements(By.xpath("//div[@class='formField TextAlignCenter']/label"));
        WebElement selectResult = listOfResults.stream()
                .filter(Item -> Item.getText().contains(string))
                .findFirst()
                .orElse(null);
        System.out.println("Total Annual Benefit is: " + _totalAnnualBenefit.getText());
        return this;
    }


}
