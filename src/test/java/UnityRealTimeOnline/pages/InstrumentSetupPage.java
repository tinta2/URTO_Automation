package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InstrumentSetupPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_ListBoxInstruments") private WebElement instrumentListBox;
    @FindBy(xpath="//option[@value='3216']") private WebElement instrumentSetup_3216; //ALS Biochemical Starchem;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonSelectNone") private WebElement selectNoneBtn;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonSelectAll") private WebElement selectAllBtn;
    @FindBy(css="#ctl00_ContentPlaceHolder1_ButtonOK") private WebElement btnOK;
    @FindBy(xpath="//option[@value='3590']")private WebElement instrumentSetup_instrumentWithSlideGen; //Vitros
//    @FindBy(css="option[value='3590']") private WebElement instrumentSetup_instrumentWithSlideGen; //Vitros
    @FindBy(xpath = "//th[normalize-space()='SG']") private WebElement label_slidegen;
    @FindBy(id ="ctl00_ContentPlaceHolder1_GridViewInstrumentTests_ctl02_TextBoxSG") private WebElement SlideGenTxtBox;
    @FindBy(css="#ctl00_ContentPlaceHolder1_GridViewInstrumentTests_ctl287_ToCreate") private WebElement cbUricAcid;
    @FindBy(css="tbody tr th:nth-child(2)") private WebElement headerSG;


    public InstrumentSetupPage(WebDriver driver) {
        super(driver);
    }

    public String instrumentListBoxExist(){

        WebElement e = wait.until(ExpectedConditions.visibilityOf(instrumentListBox));
        if(e.isEnabled()){
            System.out.println("Instrument Listbox exists");
            return "OK";
        }
        return "Not OK";
    }

    public String getSelectedInstrument(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(instrumentSetup_3216));
        //WebElement e = instrumentSetup_3116;
        return e.getText();
    }

    public void selectInstrumentOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(instrumentListBox));
        Select instrumentListBox = new Select(e);
        instrumentListBox.selectByVisibleText("A.L.S. BIOCHEMICAL STARCHEM");
    }

    public void selectInstrumentWithSlideGenOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(instrumentListBox));
        Select instrumentListBox = new Select(e);
        instrumentListBox.selectByVisibleText("VITROS 5600 (DRY SLIDE)");
    }

    public boolean selectNoneBtnEnabled(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(selectNoneBtn));
        return e.isEnabled();
    }

    public boolean selectAllBtnEnabled(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(selectAllBtn));
        return e.isEnabled();
    }

    public String slidegenLabelExist(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(label_slidegen));
        System.out.println("The header for SG is " + e.getText());
        return e.getText();
    }

    public void selectInstrument(String myInstrument){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(instrumentListBox));
        Select instrumentListBox =  new Select(e);
        instrumentListBox.selectByVisibleText(myInstrument);
    }

    public void selectTest_UricAcid(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(cbUricAcid));
        e.click();
    }

    public void clickOKButton() {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(btnOK));
        e.click();
    }


}
