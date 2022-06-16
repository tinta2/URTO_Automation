package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AuditTrailPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListEvent") private WebElement dropdownListEvent;
    @FindBy(css="#ctl00_ContentPlaceHolder1_DropDownListLabNumber") private WebElement dropdownListLabNumbder;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonShowReport") private WebElement buttonShowReport;
    @FindBy(css="option[value='93']") private WebElement eventOptionDeleteLab;
    @FindBy(css="option[value='341136']") private WebElement optionLabNumber341136;
    @FindBy(xpath="//body[1]/form[1]/div[7]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")
            private WebElement tableLabItem341136;
    @FindBy(xpath="//body[1]/form[1]/div[7]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[7]")
            private WebElement tableEventItemDeleteLab;

    public AuditTrailPage(WebDriver driver) {
        super(driver);
    }

    public void selectEventDeleteLab(){
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(dropdownListEvent));
        dropdown.click();
        WebElement e = wait.until(ExpectedConditions.visibilityOf(eventOptionDeleteLab));
        e.click();
    }

    public String getSelectedDeleteLabEventValue(){
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(dropdownListEvent)));
        return dropdown.getFirstSelectedOption().getText();
    }

    public String getEventDeleteLabDDl(){
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(dropdownListLabNumbder)));
        WebElement option = dropdown.getFirstSelectedOption();
        return option.getText();
    }

    public void selectDDLLabNumber341136(){
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(dropdownListLabNumbder));
        dropdown.click();
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionLabNumber341136));
        e.click();
    }

    public String getSelectedLabNumber341136(){
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(dropdownListLabNumbder)));
        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println("AUDIT TRAIL EVENT: " + option);
        return option.getText();
    }

    public void filterLabNumberAndEventDDL(){
        selectDDLLabNumber341136();
        selectEventDeleteLab();
    }

    public String auditTrailLabNumberForDeleteLabEvent() {
        filterLabNumberAndEventDDL();
        WebElement auditTraillabNumber = wait.until(ExpectedConditions.visibilityOf(tableLabItem341136));
        System.out.println("AUDIT TRAIL EVENT: " + auditTraillabNumber.getText());
        return auditTraillabNumber.getText();
    }

    public String auditTrailEventDeleteLab() {
        filterLabNumberAndEventDDL();
        WebElement auditTrailEvent = wait.until(ExpectedConditions.visibilityOf(tableEventItemDeleteLab));
        return auditTrailEvent.getText();
    }

}
