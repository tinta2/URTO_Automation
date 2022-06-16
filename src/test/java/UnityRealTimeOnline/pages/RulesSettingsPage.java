package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import io.cucumber.java.an.E;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RulesSettingsPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListLab") private WebElement rsLabDdl;
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListLot") private WebElement rsLotDdl;
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListLabLotTest") private WebElement rsTestDdl;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_RuleTab_Wn12sButton") private WebElement warn1_2s;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_RuleTab_Rj13sButton") private WebElement reject1_3s;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonSaveNoComment") private WebElement btnApply;
    @FindBy(css="#__tab_ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab") private WebElement tabSettings;
    //Levels in User
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_chkLevelInUse2") private WebElement cbLevel_2;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_chkLevelInUse4") private WebElement cbLevel_4;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_chkLevelInUse9") private WebElement cbLevel_9;
    //Points before evaluation
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_TextBoxPointsBeforeRule") private WebElement pointsB4EvalFld;
    //Decimal Places
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_nudDecimalA']") private WebElement decimalLevel_1Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_chkLevelInUse3") private WebElement decimalLevel_3Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_SettingTab_nudDecimalC") private WebElement decimalLevel_9Fld;
    @FindBy(css="#__tab_ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab") private WebElement tabFixedMeanSD;
    //fixed Mean and SD - SD
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedSDA") private WebElement _fixedSDLvl_1Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedSDB") private WebElement _fixedSDLvl_3Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedSDC") private WebElement _fixedSDLvl_9Fld;
    //fixed Mean
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedMeanA") private WebElement _fixedMean_level1Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedMeanB") private WebElement _fixedMean_level3Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TabsContainerSpcRuleSetting_FmSdTab_txtFixedMeanC") private WebElement _fixedMean_level9Fld;



    public RulesSettingsPage(WebDriver driver) {
        super(driver);
    }

    public RulesSettingsPage setLabNumber(String myLab){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(rsLabDdl));
        Select labDropDownList = new Select(e);
        labDropDownList.selectByValue(myLab);
        return this;
    }

    public RulesSettingsPage setLot(String myLot){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(rsLotDdl));
        Select lotDropDownList = new Select(e);
        lotDropDownList.selectByValue(myLot);
        return this;
    }

    public RulesSettingsPage setTest(String myTest){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(rsTestDdl));
        Select testDropDownList = new Select(e);
        testDropDownList.selectByValue(myTest);
        return this;
    }

    public RulesSettingsPage applyRules(){
        WebElement warnRule = wait.until(ExpectedConditions.visibilityOf(warn1_2s));
        warnRule.click();
        WebElement rejectRule = wait.until(ExpectedConditions.visibilityOf(reject1_3s));
        rejectRule.click();
        clickButtonApply();
        return this;
    }

    public void clickButtonApply(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnApply));
        e.click();
    }

    public RulesSettingsPage enterPointsB4Eval(String numPoints){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(pointsB4EvalFld));
        e.click();
        e.clear();
        e.sendKeys(numPoints);
        return this;
    }

    public RulesSettingsPage enterDecimalPlaces()  {
        WebElement myTabSettings = wait.until(ExpectedConditions.visibilityOf(tabSettings));
        myTabSettings.click();
        WebElement cbLevel1 = wait.until(ExpectedConditions.visibilityOf(decimalLevel_1Fld));
        cbLevel1.click();
        cbLevel1.clear();
        cbLevel1.sendKeys("4");
        //Thread.sleep(3000);
        WebElement cbLevel3 = wait.until(ExpectedConditions.visibilityOf(decimalLevel_3Fld));
       // cbLevel3.click();
        cbLevel3.clear();
        cbLevel3.sendKeys("4");
       // Thread.sleep(3000);
        WebElement cbLevel9 = wait.until(ExpectedConditions.visibilityOf(decimalLevel_9Fld));
        //cbLevel9.click();
        cbLevel9.clear();
        cbLevel3.sendKeys("4");
        return this;
    }

    public void clickFixedMeanSDTab(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(tabFixedMeanSD));
        e.click();
    }

    //setup Levels In Use
    public RulesSettingsPage setupSettingsTab() throws InterruptedException {
        WebElement myTabSettings = wait.until(ExpectedConditions.visibilityOf(tabSettings));
        myTabSettings.click();
        Thread.sleep(3000);
        WebElement rsLevel2 = wait.until(ExpectedConditions.visibilityOf(cbLevel_2));
        rsLevel2.click();
        Thread.sleep(3000);
        WebElement rsLevel4 = wait.until(ExpectedConditions.visibilityOf(cbLevel_4));
        rsLevel4.click();
        Thread.sleep(3000);
        WebElement rsLevel9 = wait.until(ExpectedConditions.visibilityOf(cbLevel_9));
        rsLevel9.click();
        clickButtonApply();
        return this;
    }

    public RulesSettingsPage enterFixedSd_Level1(String mySd){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedSDLvl_1Fld));
        e.sendKeys(mySd);
        return this;
    }

    public RulesSettingsPage enterFixedSd_Level3(String mySd){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedSDLvl_3Fld));
        e.sendKeys(mySd);
        return this;
    }

    public RulesSettingsPage enterFixedSd_Level9(String mySd){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedSDLvl_9Fld));
        e.sendKeys(mySd);
        return this;
    }

    public RulesSettingsPage enterFixedMean_A(String myFMean){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedMean_level1Fld));
        e.sendKeys(myFMean);
        return this;
    }

    public RulesSettingsPage enterFixedMean_B(String myFMean){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedMean_level3Fld));
        e.sendKeys(myFMean);
        return this;
    }

    public RulesSettingsPage enterFixedMean_C(String myFMean){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(_fixedMean_level9Fld));
        e.sendKeys(myFMean);
        return this;
    }
}
