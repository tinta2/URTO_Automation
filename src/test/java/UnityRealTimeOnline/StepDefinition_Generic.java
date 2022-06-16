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

public class StepDefinition_Generic {
    private WebDriver driver;

    @Given("User is login in Lot Page")
    public void userIsLoginInLotPage() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");

        new HomePage(driver).
                selectMenuConfigure().
                selectLotOption();
    }

    //Scenario 0:  Precondition
    @When("User creates Non-Bio-rad Lot")
    public void userCreatesNonBioRadLot() {
        LotPage lotPage = new LotPage(driver);
        lotPage.selectOtherControlNameOption();
        lotPage.configureNBRLot("NBR1", "NBR1", "NBRManuf", "Serum", "9");
    }

    @Then("Lot is added to Open lots list")
    public void lot_is_added_to_open_lots_list() {
        LotPage lotPage = new LotPage(driver);
        String lotName = lotPage.getNBRLot();
        System.out.println("NBR Lot created: " + lotName);
        Assert.assertEquals("NBR1", lotName);
    }

    @Given("User is login in STPDE")
    public void userIsLoginInSTPDE() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionSTPDE();
    }

    //(0.1) Precondition Add test to NBR Lot
    @Given("User is login in Test")
    public void userIsLoginInTest() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuConfigure();
        homePage.selectTestOption();
    }

    @When("User clicks the Inst Setup button")
    public void userClicksTheInstSetupButton() {
        TestPage testPage = new TestPage(driver);
        testPage.clickInstrumentSetupBtn();
    }

    @And("User selects Roche Cobas {int} instrument")
    public void userSelectsRocheCobasInstrument(int arg0) {
        InstrumentSetupPage instrumentSetupPage = new InstrumentSetupPage(driver);
        instrumentSetupPage.selectInstrument("ROCHE COBAS 6000");
    }

    @And("User selects Uric Acid test")
    public void userSelectsUricAcidTest() {
        InstrumentSetupPage instrumentSetupPage = new InstrumentSetupPage(driver);
        instrumentSetupPage.selectTest_UricAcid();
    }

    @Then("test is created successfully")
    public void testIsCreatedSuccessfully() {
        InstrumentSetupPage instrumentSetupPage = new InstrumentSetupPage(driver);
        instrumentSetupPage.clickOKButton();
    }

    @When("User enters data entry")
    public void userEntersDataEntry() {
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionSTPDE();

    }

    //Scenario (0.2) Precondition Setup Rule Settings
    @Given("User is login in RuleSettings")
    public void userIsLoginInRuleSettings() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuConfigure();
        homePage.navigateToRulesSettings();
    }


    @When("User configures Rules Settings lab lot test")
    public void userConfiguresRulesSettingsLabLotTest() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.setLabNumber("654328");
        rulesSettingsPage.setLot("NBR1");
        //rulesSettingsPage.setTest("5731180");

    }

    //applies 1-2s[W] and 1-3s
    @And("user applies rules")
    public void userAppliesRules() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.applyRules();
    }

    @Then("Rules are applied to the test")
    public void rulesAreAppliedToTheTest() {
        //to be added when data entry is showing rules
    }

    @When("User configures Settings for levels in use")
    public void userConfiguresSettingsForLevelsInUse() throws InterruptedException {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.setupSettingsTab();
        rulesSettingsPage.clickButtonApply();
        rulesSettingsPage.clickFixedMeanSDTab();
    }

    @And("User configures settings for decimal places")
    public void userConfiguresSettingsForDecimalPlaces() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.enterDecimalPlaces();
        rulesSettingsPage.clickButtonApply();
        rulesSettingsPage.clickButtonApply();
    }

    @When("User clicks Fixed Mean and SD tab")
    public void userClicksFixedMeanAndSDTab() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.clickFixedMeanSDTab();
    }

    @And("user applied fixed SD to all levels in use")
    public void userAppliedFixedSDToAllLevelsInUse() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.enterFixedSd_Level1("0.0347");
        rulesSettingsPage.enterFixedSd_Level3("0.0884");
        rulesSettingsPage.enterFixedSd_Level9("0.1120");
    }

    @And("user applied fixed mean to all levels in use")
    public void userAppliedFixedMeanToAllLevelsInUse() {
        RulesSettingsPage rulesSettingsPage = new RulesSettingsPage(driver);
        rulesSettingsPage.enterFixedMean_A("-1.000");
        rulesSettingsPage.enterFixedMean_B("-2.000");
        rulesSettingsPage.enterFixedMean_C("-3000");
        rulesSettingsPage.clickButtonApply();
    }


    @Given("User is login in AG Imprecision BV")
    public void userIsLoginInAGImprecisionBV() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuConfigure();
        homePage.navigateToAGImprecisionBV();
    }

    @When("User selects Use this application to evaluate preformance")
    public void userSelectsUseThisApplicationToEvaluatePreformance() {
        ImprecisionBVPage imprecisionBVPage = new ImprecisionBVPage(driver);
        imprecisionBVPage.checkUseThisApp();
    }


    @And("User selects Manually enter target value")
    public void userSelectsManuallyEnterTargetValue() {
        ImprecisionBVPage imprecisionBVPage = new ImprecisionBVPage(driver);
        imprecisionBVPage.selectManuallyEnterTargetValue();
    }

    @And("user applied target values to all levels in use and save")
    public void userAppliedTargetValuesToAllLevelsInUseAndSave() {
        ImprecisionBVPage imprecisionBVPage = new ImprecisionBVPage(driver);
        imprecisionBVPage.enterTargetValues("0.000", "0.000", "0.000");
        imprecisionBVPage.clickSaveBtn();
    }

    @Given("User is login Lab Page")
    public void userIsLoginLabPage() throws InterruptedException {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        new HomePage(driver).selectMenuConfigure().selectLabOption();
        new LabPage(driver).clickClearBtn();
    }

    @When("User enters lab information")
    public void userEntersLabInformation() throws InterruptedException, IOException {
        LabInformation labInformation = new LabInformation();
        InputStream is = getClass().getClassLoader().getResourceAsStream("myLabInformation.json");
        labInformation = JacksonUtils.deserializeJson(is, labInformation);
        LabPage labPage = new LabPage(driver);
        labPage.setLabInformation(labInformation);
        //Thread.sleep(2000);
        labPage.clickAddLabBtn();
    }

    @Then("lab is created")
    public void labIsCreated() throws InterruptedException {
        LabPage labPage = new LabPage(driver);
        String labNo = labPage.getNewLab().toString();
        System.out.println("Lab number found is" + labNo);
        Assert.assertEquals("341134: Test Lab", labNo);
    }
}
