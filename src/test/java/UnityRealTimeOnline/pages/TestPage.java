package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TestPage extends BasePage {

    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_INSTRUMENT_SETUP") private WebElement btnInstrumentSetup;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonOK") private WebElement btnOK;
    @FindBy(xpath="//tr[@id='ctl00_ContentPlaceHolder1_GridViewOpenedTests_ctl02']") private WebElement openTestListbox;
    @FindBy(xpath="//td[normalize-space()='Creatinine']") private WebElement test;

    public TestPage(WebDriver driver) {
        super(driver);
    }

    public void clickInstrumentSetupBtn(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnInstrumentSetup));
        e.click();
    }

    public void clickOKBtn(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnOK));
        e.click();
    }

//    public String getFirstTestInOpen(){
//        WebElement e = wait.until(ExpectedConditions.visibilityOf(test));
//        e.click();
//        return e.getText();
//    }

    public void testCreatinineIsCreated(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(openTestListbox));
        Select instrumentListBox = new Select(e);
        instrumentListBox.selectByVisibleText("Creatinine");
    }

    //return test name of test created
    public String getTestNameFromOpen(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(test));
        System.out.println("Test is:  " + e.getText());
        return e.getText();
    }

}


