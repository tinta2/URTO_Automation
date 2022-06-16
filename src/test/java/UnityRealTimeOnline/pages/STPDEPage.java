package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class STPDEPage extends BasePage {
    @FindBy(xpath="//td[contains(text(),'Date & Time')]") private WebElement headerDate;
    @FindBy(id="ctl00_ContentPlaceHolder1_DropDownListLab") private WebElement labDDL;
    @FindBy(id="ctl00_ContentPlaceHolder1_DropDownListLot") private WebElement lotDDL;
    @FindBy(id="ctl00_ContentPlaceHolder1_DropDownListLabLotTest") private WebElement testDDL;
    @FindBy(id="ctl00_ContentPlaceHolder1_GridData1~TR~0~_TOPGROUP_^1*R0Cell1_DateTimeBox1") private WebElement dateFld;
    //data entry Level 1
    @FindBy(id="ctl00_ContentPlaceHolder1_GridData1~TR~0~_TOPGROUP_^3*R0Cell2_ValueBox1")private WebElement level1Fld;
    //data entry Level 2 and 3
    @FindBy(id="ctl00_ContentPlaceHolder1_GridData1~TR~0~_TOPGROUP_^3*R0Cell6_ValueBox2") private WebElement level2Fld;
    @FindBy(id="ctl00_ContentPlaceHolder1_GridData1~TR~0~_TOPGROUP_^3*R0Cell10_ValueBox3") private WebElement level3Fld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_Save") private WebElement btnSave;
    @FindBy(css="select[onchange='OnBBSelPgCh(event, this, \"ctl00_ContentPlaceHolder1_GridData1\", \"0~5\")']") private WebElement ddlPage;
//    @FindBy(id="ctl00_ContentPlaceHolder1_Save") private WebElement btnSave;



    public STPDEPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderDate(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(headerDate));
        return e.getText();
    }

     public STPDEPage setLabNumber(String myLab){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(labDDL));
        Select labDropDownList = new Select(e);
        labDropDownList.selectByVisibleText(myLab);
        return this;
    }

    public STPDEPage setLot(String myLot){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lotDDL));
        Select lotDropDownList = new Select(e);
        lotDropDownList.selectByVisibleText(myLot);
        return this;
    }

    public STPDEPage setTest(String myTest){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(testDDL));
        Select testDropDownList = new Select(e);
        testDropDownList.selectByVisibleText(myTest);
        return this;
    }

    public STPDEPage setDate(String myDate){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(dateFld));
        e.sendKeys(myDate);
        return this;
    }

    public void clickSaveBtn(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnSave));
        e.click();
    }

    public STPDEPage selectPageNumber(String myPage){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(ddlPage));
        Select pageDropDownList = new Select(e);
        pageDropDownList.selectByValue(myPage);
        e.click();
        return this;
    }

    //Data entry - date
    public STPDEPage enterDate(String date){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level1Fld));
            e.click();
            e.sendKeys(date);
            return this;
    }

    public STPDEPage enterDataLevel1(String myData){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level1Fld));
        e.click();
        e.clear();
        e.sendKeys(myData);
        return this;
    }

    public String getLevel1Value(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level1Fld));
        return  e.getAttribute("value");
    }

    public STPDEPage enterDataLevel2(String myData) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level3Fld));
        e.click();
        e.sendKeys(myData);
        clickSaveBtn();
        return this;
    }
    public String getLevel2Value(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level2Fld));
        return  e.getAttribute("value");
    }

    public STPDEPage enterDataLevel3(String myData){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level3Fld));
        e.click();
        e.sendKeys(myData);
        return this;

    }

    public String getLevel3Value(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(level3Fld));
        return  e.getAttribute("value");
    }

    public void takeScreenshot(String FileName) throws IOException {
        //create instance of a file
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\user\\tguevara\\cucumberBDD\\: " + FileName + ".jpeg"));
    }

}
