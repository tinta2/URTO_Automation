package UnityRealTimeOnline;

import UnityRealTimeOnline.factory.DriverManager;
import UnityRealTimeOnline.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinition_180702 {
    private WebDriver driver;

    @Given("user is logged in Data Entry")
    public void userIsLoggedInDataEntry() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        new HomePage(driver).selectMenuDataEntry();
    }

    //Scenario 1 MTPDE**************
    @When("User is in Multi Test Point Data Entry page")
    public void userIsInMultiTestPointDataEntryPage() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionMTPDE();
    }

    @Then("The header for date on the grid is Date")
    public void theHeaderForDateOnTheGridIsDate() {
        MTPDEPage mtpdePage = new MTPDEPage(driver);
        String header = mtpdePage.getHeaderForDate();
        Assert.assertEquals("Date", header);
        driver.close();
    }

    //Scenario 2 - MTSDE****************************
    @When("User is in Multi Test Summary Data Entry page")
    public void userIsInMultiTestSummaryDataEntryPage() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionMTSDE();
    }

    @Then("The header for MTSDE date on the grid is Date")
    public void theHeaderForMTSDEDateOnTheGridIsDate() {
        MTSDEPage mtsdePage = new MTSDEPage(driver);
        String header = mtsdePage.getHeaderDate();
        Assert.assertEquals("Date", header);
        driver.close();
    }

    //Scenario 3 - STPDE******************************
    @When("User is in Single Test Point Data Entry page")
    public void userIsInSingleTestPointDataEntryPage() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionSTPDE();
    }

    @Then("The header for STPDE date on the grid is Date Entered")
    public void theHeaderForSTPDEDateOnTheGridIsDateEntered() {
        STPDEPage stpdePage = new STPDEPage(driver);
        String header = stpdePage.getHeaderDate();
        Assert.assertEquals("Date & Time", header);
        driver.close();
    }

    //Scenario 4 - STSDE *******************************
    @When("User is in Single Test Summary Data Entry page")
    public void userIsInSingleTestSummaryDataEntryPage() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionSTSDE();
    }

    @Then("The header for STSDE date on the grid is Date Entered")
    public void theHeaderForSTSDEDateOnTheGridIsDateEntered() {
        STSDEPage stsdEpage = new STSDEPage(driver);
        String header = stsdEpage.getHeaderDate();
        Assert.assertEquals("Date & Time", header);
        driver.close();
    }


}
