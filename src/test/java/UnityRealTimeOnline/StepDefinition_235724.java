package UnityRealTimeOnline;

import UnityRealTimeOnline.factory.DriverManager;
import UnityRealTimeOnline.pages.HomePage;
import UnityRealTimeOnline.pages.LoginPage;
import UnityRealTimeOnline.pages.STPDEPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinition_235724 {
    private WebDriver driver;

    //Scenario 1
    @Given("user is logged in STPDE")
    public void userIsLoggedInSTPDE() {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new  LoginPage(driver);
        loginPage.load("/LoginForm.aspx");
        loginPage.login("654328", "Biorad123");
        HomePage homePage = new HomePage(driver);
        homePage.selectMenuDataEntry();
        homePage.selectOptionSTPDE();
    }
    @When("User enters zero in level1")
    public void userEntersZeroInLevel1() {
        STPDEPage stpdePage = new STPDEPage(driver);
        stpdePage.enterDataLevel1("1.0000");
        stpdePage.clickSaveBtn();
        //stpdePage.takeScreenshot("STPDE");

    }

    @When("User enters zero in level_{int} and level_{int}")
    public void userEntersZeroInLevel_3AndLevel_9(int arg0, int arg1) {
        STPDEPage stpdePage = new STPDEPage(driver);
        stpdePage.enterDataLevel2("2.000");
        stpdePage.clickSaveBtn();
        stpdePage.enterDataLevel3("3.000");
        stpdePage.clickSaveBtn();
    }


    @Then("User is able to save the zero value")
    public void userIsAbleToSaveTheZeroValue() throws InterruptedException, IOException {
        STPDEPage stpdePage = new STPDEPage(driver);
        stpdePage.clickSaveBtn();
        Thread.sleep(5000);
        String myValue = stpdePage.getLevel1Value();
        System.out.println("LEVEL 1 LINE 2 value is: " + myValue);
        Assert.assertEquals("1.0000", myValue );
        //stpdePage.takeScreenshot("Line 8 STPDE");
        //Assert.assertEquals("0.00", stpdePage.getLevel1Value().toString());
        driver.quit();
    }
    @Then("User is able to save the zero values in level3 and level9")
    public void userIsAbleToSaveTheZeroValuesInLevel3AndLevel9() throws IOException {
        STPDEPage stpdePage = new STPDEPage(driver);
        String myValue2 = stpdePage.getLevel2Value();
        String myValue3 = stpdePage.getLevel3Value();
        System.out.println("LEVEL 2 LINE 2 value is: " + myValue2);
        System.out.println("LEVEL 3 LINE 2 value is: " + myValue2);
        Assert.assertEquals("2.000", myValue2 );
        Assert.assertEquals("3.000", myValue3 );
        driver.quit();
    }

}
