package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import io.cucumber.java.bs.I;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ImprecisionBVPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_CheckBoxUseI") private WebElement cbUseThisApp;
    @FindBy(css="#ctl00_ContentPlaceHolder1_RadioButtonUseManualI") private WebElement rbManuallyEnterTV;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxTargetValueLev1I") private WebElement targetValueLvl_1Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxTargetValueLev2I") private WebElement targetValueLvl_3Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxTargetValueLev3I") private WebElement targetValueLvl_9Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonSaveNoComment") private WebElement btnSave;


    public ImprecisionBVPage(WebDriver driver) {
        super(driver);
    }

    public ImprecisionBVPage checkUseThisApp(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(cbUseThisApp));
        e.click();
        return this;
    }

    public ImprecisionBVPage selectManuallyEnterTargetValue(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(rbManuallyEnterTV));
        e.click();
        return this;
    }

    public ImprecisionBVPage enterTargetValueLvl1(String myTargetValue){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(targetValueLvl_1Fld));
        e.sendKeys(myTargetValue);
        return this;
    }

    public ImprecisionBVPage enterTargetValueLvl3(String myTargetValue){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(targetValueLvl_3Fld));
        e.sendKeys(myTargetValue);
        return this;
    }

    public ImprecisionBVPage enterTargetValueLvl9(String myTargetValue){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(targetValueLvl_9Fld));
        e.sendKeys(myTargetValue);
        return this;
    }

    public ImprecisionBVPage enterTargetValues(String tV1, String tV3, String tV9){
        enterTargetValueLvl1(tV1);
        enterTargetValueLvl3(tV3);
        enterTargetValueLvl9(tV9);
        return this;
    }

    public ImprecisionBVPage clickSaveBtn(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnSave));
        e.click();
        return this;
    }

}
