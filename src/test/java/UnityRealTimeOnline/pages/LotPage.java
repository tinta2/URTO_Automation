package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LotPage extends BasePage {
    private String mylotNumber;
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListLabID") private WebElement labNumberDDL;
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListControlName") private WebElement dropdownControlName;
    @FindBy(xpath="//option[@value='Multiqual Premium Assayed']") private WebElement optionMultiqualPremiumAssayed;
    @FindBy(xpath="//option[@value='86910']") private WebElement lot86910;
    @FindBy(xpath="//option[@value='Other']") private WebElement controlOptionOther;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_BUTTON_Add") private WebElement addBtn;
    @FindBy(css="option[value='86910']") private WebElement lotNumber;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_ControlName") private WebElement nbrControlNameFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_LOTNO") private WebElement masterLotNumberFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_OTHER_MANUFACTURER") private WebElement nbrManufacturerFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_comboBoxSystem") private WebElement nbrMatrixDDL;
    @FindBy(css="#ctl00_ContentPlaceHolder1_nudLevels_ctl00") private WebElement nbrLevelsFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDOK") private WebElement btnOK;
    @FindBy(xpath="//tr[@id='ctl00_ContentPlaceHolder1_GridViewOpenedLots_Row_1']//td[2]") private WebElement nbrLot;



    public LotPage(WebDriver driver) {
        super(driver);
    }

    public LotPage enterNbrControlNameFld(String nbrControlName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(nbrControlNameFld));
        e.sendKeys(nbrControlName);
        return this;
    }

    public LotPage enterMasterLotNumber(String masterLotNumber) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(masterLotNumberFld));
        e.sendKeys(masterLotNumber);
        return this;
    }

    public LotPage enterManufacturer(String nbrManufacturer) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(nbrManufacturerFld));
        e.sendKeys(nbrManufacturer);
        return this;
    }

    public LotPage enterLevelInUser(String level) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(nbrLevelsFld));
        e.click();
        e.sendKeys(level);
        return this;
    }

    ////option[@value='Multiqual Premium Assayed']
//    public LotPage selectOptionControlName(String controlName){
//        WebElement controlNameDropdownlist = wait.until(ExpectedConditions.visibilityOf(dropdownControlName));
//        controlNameDropdownlist.click();
//        By optionControlName = By.xpath("option[@value='" + controlName + "']");
//        driver.findElement(optionControlName).click();
//
//        controlNameDropdownlist.se
//
//        return this;
//    }

    public void selectMultiqualPremiumAssayedLot(){
        WebElement controlNameDropdownlist = wait.until(ExpectedConditions.visibilityOf(dropdownControlName));
        controlNameDropdownlist.click();
        WebElement optMultiqualPremiumAssayed = wait.until(ExpectedConditions.visibilityOf(optionMultiqualPremiumAssayed));
        optMultiqualPremiumAssayed.click();
    }

    public void selectOtherControlNameOption(){
        WebElement controlNameDropdownlist = wait.until(ExpectedConditions.visibilityOf(dropdownControlName));
        controlNameDropdownlist.click();
        WebElement optOther = wait.until(ExpectedConditions.visibilityOf(controlOptionOther));
        optOther.click();
        clickAddButton();
    }

    //refactor this later to parameter
    public void selectLotNumber(String lotNumber){
        By dropdownlistLotNumber = By.cssSelector("#ctl00_ContentPlaceHolder1_DropDownListLotNumber");
        driver.findElement(dropdownlistLotNumber).click();
        By optionLotNumber = By.cssSelector("option[value='"+ lotNumber +"']");
        driver.findElement(optionLotNumber).click();
    }

    public By getControlNameOption(String controlName){
        return By.xpath("option[@value='" + controlName + "']");
    }


    //this is for NBR lot configuration
    public LotPage selectControlName(String controlName){
        enterNbrControlNameFld(controlName);
        WebElement e = wait.until(ExpectedConditions.visibilityOf(addBtn));
        e.click();
        return this;
    }

    public void select86910Lot(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lot86910));
        e.click();
    }

    public void clickAddButton(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        e.click();
    }

    public String openLot86910(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lotNumber));
        return e.getText();
    }

    public void deleteLot(String lotNumber){
        WebElement controlNameDropdownlist = wait.until(ExpectedConditions.visibilityOf(dropdownControlName));
        controlNameDropdownlist.click();
        By optionLotNumber = By.cssSelector("option[value='"+ lotNumber +"']");
        driver.findElement(optionLotNumber).click();
    }

    //create NBR lot with 9 levels
    public void configureNBRLot(String ctrlName, String masterLotNo, String manufacturer, String matrix, String level){
        WebElement controlName = wait.until(ExpectedConditions.visibilityOf(nbrControlNameFld));

        enterNbrControlNameFld(ctrlName);
        enterMasterLotNumber(masterLotNo);
        enterManufacturer(manufacturer);

        Select matrixDDL = new Select(nbrMatrixDDL);
        matrixDDL.selectByVisibleText(matrix);

        enterLevelInUser(level);

        WebElement okBtn = wait.until(ExpectedConditions.visibilityOf(btnOK));
        okBtn.click();

    }

    public String getNBRLot(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(nbrLot));
        return e.getText();
    }


    public String getTitle(){
        return driver.getTitle();
    }

}
