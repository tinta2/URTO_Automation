package UnityRealTimeOnline;

import UnityRealTimeOnline.factory.DriverManager;
import UnityRealTimeOnline.objects.LabInformation;
import UnityRealTimeOnline.pages.*;
import UnityRealTimeOnline.utils.JacksonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class StepDefinition1 {
    private WebDriver driver;

    //Login
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
      driver = DriverManager.getDriver();
      //driver = new ChromeDriver();
      System.out.println("DRIVER: " + driver);
      // driver.get("https://10.19.27.5");
      new LoginPage(driver).load("/LoginForm.aspx");
    }
    //Login
    @When("I enter my credentials")
    public void i_enter_my_credentials(List<Map<String, String>> loginDetails) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("654328", "Biorad123");
    }

    //Login
    @Then("I am able to successfully login")
    public void i_am_able_to_successfully_login() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("654328, Log out",loginPage.getlogoutUser());
        driver.quit();
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
          //   loginPage.login("userIM", "Biorad123");
    }

    //Scenario 2 PBI_117416
    //add test from instrument setup
    @Given("User is in Instrument Setup page")
    public void userIsInInstrumentSetupPage() {
        new HomePage(driver).
                selectMenuConfigure().
                selectTestOption();
        new TestPage(driver).clickInstrumentSetupBtn();
    }


    //add test from instrument setup
    @When("user select instrument")
    public void userSelectInstrument() {
        InstrumentSetupPage instrumentSetupPage = new InstrumentSetupPage(driver);
        instrumentSetupPage.selectInstrumentOption();
    }

    //add test from instrument setup
    @Then("Select None button is disabled")
    public void selectNoneButtonIsDisabled() {
        Boolean btnDisabled = new InstrumentSetupPage(driver).selectNoneBtnEnabled();
        Assert.assertFalse(btnDisabled);
        driver.quit();
    }

    @And("Select All button is enabled")
    public void selectAllButtonIsEnabled() {
        Assert.assertTrue(new InstrumentSetupPage(driver).selectAllBtnEnabled());
    }

    //Scenario2
    @When("user selects a test from the grid")
    public void userSelectsATestFromTheGrid() {
        new CommonPage(driver).selectTest();
    }
    //Scenario3
    @And("user clicks the OK button")
    public void userClicksTheOKButton() {
          new TestPage(driver).clickOKBtn();
    }

      //Scenario4  SlideGen instrument
    @When("user selects instrument with slide gen")
    public void userSelectsInstrumentWithSlideGen() {
        new TestPage(driver).clickInstrumentSetupBtn();
        new InstrumentSetupPage(driver).selectInstrumentWithSlideGenOption();
    }

    @Then("test is added to Open Test")
    public void testIsAddedToOpenTest() {
        TestPage testPage= new TestPage(driver);
        String testName = testPage.getTestNameFromOpen();
        System.out.println(testName);
        Assert.assertEquals("Creatinine", testName);
        driver.quit();
    }

    @Then("the SG column value exist")
    public void theSGColumnValueExist() {
        InstrumentSetupPage instrumentSetupPage = new InstrumentSetupPage(driver);
        System.out.println("Label for SlideGen is : " + instrumentSetupPage.slidegenLabelExist());
        driver.quit();
    }
    //Add a Lab and be able to delete this Lab for Audit Trail scenario 1
    @And("User is in Lab page")
    public void userIsInLabPage() {
        new HomePage(driver).selectMenuConfigure().selectLabOption();
    }


    @Then("the added lab is recorded in AuditTrail")
    public void theAddedLabIsRecordedInAuditTrail() {
        new HomePage(driver).selectMenuReport().selectReportOptionAuditTrail() ;
        driver.quit();
    }


    @When("user deletes {string} Lab")
    public void userDeletesLab(String labNumber) {
        LabPage labPage = new LabPage(driver);
        labPage.deleteFromOpenLabListBox("341136");
    }

    @Then("the deleted lab is recorded in AuditTrail")
    public void theDeletedLabIsRecordedInAuditTrail() {
        new HomePage(driver).
                navigateToAuditTrail();
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        auditTrailPage.selectEventDeleteLab();
        String eventValue = auditTrailPage.getSelectedDeleteLabEventValue();
        Assert.assertEquals("Delete Lab", eventValue);
        driver.quit();
    }

//  ****115244 AuditTrail Scenario 3
    @And("User is on AuditTrail page")
    public void userIsOnAuditTrailPage() {
        new HomePage(driver).navigateToAuditTrail();
    }

    @When("User expands the Event dropdown list")
    public void userExpandsTheEventDropdownList() {
        new HomePage(driver).
                navigateToAuditTrail();
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        auditTrailPage.selectEventDeleteLab();

    }

    @Then("Delete Lab event is listed")
    public void deleteLabEventIsListed() {
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        String eventDeleteLab = auditTrailPage.getSelectedDeleteLabEventValue();
        Assert.assertEquals("Delete Lab", eventDeleteLab);
        driver.quit();
    }

    //****115244 AuditTrail Scenario 3
    @When("User expands the Lab Number dropdown list")
    public void userExpandsTheLabNumberDropdownList() {
        new HomePage(driver).
                navigateToAuditTrail();
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        auditTrailPage.selectDDLLabNumber341136();
    }


    @Then("Lab number 341134 is selected")
    public void labNumberIsSelected() {
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        String labNumber341136 =  auditTrailPage.getSelectedLabNumber341136();
        Assert.assertEquals("341136", labNumber341136);
        driver.quit();
    }

    //****115244 AuditTrail Scenario 4
    @When("Filters Lab Number and Event dropdown list")
    public void filtersLabNumberAndEventDropdownList() {
        new HomePage(driver).
                navigateToAuditTrail();
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        auditTrailPage.filterLabNumberAndEventDDL();
    }

    //on 5/16/2022 8:13:45 AM
    @Then("the grid displays lab number and event Delete Lab")
    public void theGridDisplaysLabNumberAndEventDeleteLab() {
        AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
        String labNo = auditTrailPage.auditTrailLabNumberForDeleteLabEvent();
        String event = auditTrailPage.auditTrailEventDeleteLab();
        System.out.println("LAB FROM GRID VALUE: " + labNo);
        Assert.assertEquals("341136" ,labNo);
        System.out.println("EVENT FROM GRID VALUE: " + event);
        Assert.assertEquals("Delete Lab", event);
        driver.quit();
    }

    //**********Create Lab********************
    @And("User is on the lab page")
    public void userIsOnTheLabPage() throws InterruptedException {
        new HomePage(driver).
                selectMenuConfigure().
                selectLabOption();
        new LabPage(driver).clickClearBtn();
    }


    //Add Lot
    @And("User is on the Lot page")
    public void userIsOnTheLotPage() {
        new HomePage(driver).
                selectMenuConfigure().
                selectLotOption();
    }

    @When("user selects Multiqual Premium Assayed Lot")
    public void userSelectsMultiqualPremiumAssayedLot() {
        LotPage lotPage = new LotPage(driver);
        lotPage.selectMultiqualPremiumAssayedLot();
    }

    @And("user selects {int} to add lot")
    public void userSelectsToAddLot(int arg0) {
        LotPage lotPage = new LotPage(driver);
        lotPage.select86910Lot();
        lotPage.clickAddButton();
    }

    @Then("Lot is in the Open Lots list")
    public void lotIsInTheOpenLotsList() {
        LotPage lotPage = new LotPage(driver);
        String lotNo = lotPage.openLot86910();
        System.out.println("Title: " + lotPage.getTitle());
        Assert.assertEquals(lotNo, "86910");
        driver.quit();
    }


}
