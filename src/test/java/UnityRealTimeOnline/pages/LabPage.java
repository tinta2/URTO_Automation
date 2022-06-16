package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import UnityRealTimeOnline.objects.LabInformation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LabPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabNumber") private WebElement inputLabNumberFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabDescription") private WebElement inputDescriptionFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabName") private WebElement inputLabNameFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabDepartment") private WebElement inputDepartmentFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabContact") private WebElement inputContactFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabAddress1") private WebElement inputAddress1Fld;
    @FindBy(css= "#ctl00_ContentPlaceHolder1_TextBoxLabCity") private WebElement inputCityFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabState") private WebElement inputStateFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabZipCode") private WebElement inputPostalCodeFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabAreaCode") private WebElement inputAreaCodeFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabTelephone") private WebElement inputTelephoneFld;
    @FindBy(css="#ctl00_ContentPlaceHolder1_TextBoxLabEmail")private WebElement inputEmailFld;
    @FindBy(id="ctl00_ContentPlaceHolder1_IDC_Add") private WebElement addBtn;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_Clear") private WebElement clearBtn;
    @FindBy(id="ctl00_ContentPlaceHolder1_ListBoxOpenedLabs") private WebElement openLabListBox;
    @FindBy(css="#ctl00_ContentPlaceHolder1_IDC_Delete") private WebElement deleteBtn;
    @FindBy(css="option[value='341134']") private WebElement newLab341134;

    private final By overlay = By.cssSelector(".blockUi.blockOverlay");


    public LabPage(WebDriver driver) {
        super(driver);
    }

    public void deleteFromOpenLabListBox(String labNumber) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(openLabListBox));
//        WebElement btnDelete = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));

        Select lab = new Select(e);
        List<WebElement> alle = lab.getOptions();

        for (int i=0; i<alle.size(); i++) {

            System.out.println("LabNumber :" + alle.get(i).getAttribute("value"));
            System.out.println("Lab Number argument:  " + labNumber);

            if (alle.get(i).getAttribute("value").trim().equalsIgnoreCase(labNumber.trim())) {
                try {
                    alle.get(i).click();
//                    System.out.println("Found lab to be deleted: " + alle.get(i).getAttribute("value"));
                    WebElement btnDelete = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
                    btnDelete.click();
//                    System.out.println("Delete button clicked just now....");

                    try {
//                        System.out.println("Try/Catch within 1st Try");
                        Alert confirmationAlert = driver.switchTo().alert();
                        String message = confirmationAlert.getText();
                        System.out.println("Confirmation Alert: " + message);
//                        Assert.assertEquals(message, "Are you sure you want to delete this lab?");
                        waitForOverlaysToDisappear(overlay);
                        confirmationAlert.accept();
                        System.out.println("Alert accepted");
                    } catch (NoAlertPresentException ex){
                        ex.printStackTrace();
                    }
                } catch (UnhandledAlertException f) {
                        System.out.println("Exception for delete lab: " + f);
                }

            }
        }
    }

    public LabPage enterLabNumber(String labNumber){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputLabNumberFld));
        try{
            e.sendKeys(labNumber);
        }
        catch (StaleElementReferenceException ex){
            e.sendKeys();
        }

        return this;
    }

    public LabPage enterLabDescription(String myDescription){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputDescriptionFld));
        e.sendKeys(myDescription);
        return this;
    }

    public LabPage enterLabName(String labName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputLabNameFld));
        e.sendKeys(labName);
        return this;
    }


    public LabPage enterDepartment(String department) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputDepartmentFld));
        e.sendKeys(department);
        return this;
    }

    public LabPage enterContact(String contact) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputContactFld));
        e.sendKeys(contact);
        return this;
    }

    public LabPage enterAddress1(String address) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputAddress1Fld));
        e.sendKeys(address);
        return this;
    }

    public LabPage enterCity(String city) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputCityFld));
        e.sendKeys(city);
        return this;
    }

    public LabPage enterState(String state) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputStateFld));
        e.sendKeys(state);
        return this;
    }

    public LabPage enterPostalCode(String postalCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputPostalCodeFld));
        e.sendKeys(postalCode);
        return this;
    }

    public LabPage enterAreaCode(String areaCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputAreaCodeFld));
        e.sendKeys(areaCode);
        return this;
    }

    public LabPage enterTelephone(String telephone) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputTelephoneFld));
        e.sendKeys(telephone);
        return this;
    }

    public LabPage enterEmail(String email) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(inputEmailFld));
        e.sendKeys(email);
        return this;
    }

    public void clickAddLabBtn() throws InterruptedException {
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        Thread.sleep(2000);
        e.click();
    }

    public void clickClearBtn() throws InterruptedException {
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(clearBtn));
        e.click();
        Thread.sleep(3000);
    }

    public String getLabNumber(){
        return inputLabNumberFld.getText();
    }

    public String getNewLab(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(newLab341134));
        return e.getText();
    }

    public LabPage setLabInformation(LabInformation labInformation){
        return  enterLabNumber(labInformation.getLabNumber()).
                enterLabDescription(labInformation.getDescription()).
                enterLabName(labInformation.getLabName()).
                enterDepartment(labInformation.getDepartment()).
                enterContact(labInformation.getContact()).
                enterAddress1(labInformation.getAddress()).
                enterCity(labInformation.getCity()).
                enterState(labInformation.getState()).
                enterPostalCode(labInformation.getPostalCode()).
                enterAreaCode(labInformation.getAreaCode()).
                enterTelephone(labInformation.getTelephone()).
                enterEmail(labInformation.getEmail());
    }
}
