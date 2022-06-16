package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import io.cucumber.java.bs.I;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css="li[id='View'] a[class='top']") private WebElement menuConfigure;
    @FindBy(css="a[onclick=\"menuClick('PageLabLotTest.aspx');\"]") private WebElement configureLinkTest;
    @FindBy(css="a[onclick=\"menuClick('labsWebForm.aspx');\"]") private WebElement configureLinkLab;
    @FindBy(css="a[onclick=\"menuClick('lotsWebForm.aspx');\"]") private WebElement configureLinkLot;
    @FindBy(css=".top.nav-current") private WebElement menuReport;
    @FindBy(css="a[onclick=\"menuClick('AuditTrail.aspx');\"]") private WebElement menuOptionAuditTrail;
    @FindBy(xpath="//a[normalize-space()='Panel »']") private WebElement configurePanelOption;
    @FindBy(xpath="//a[normalize-space()='Add']") private WebElement panelOptionAdd;
    @FindBy(xpath="//a[normalize-space()='Update/Sort Tests']") private WebElement panelOptionUpdateSort;
    @FindBy(xpath="//a[normalize-space()='Reports']") private WebElement menuReports;
    @FindBy(css="/a[onclick=\"menuClick('AuditTrail.aspx');\"]") private WebElement reportOptionAuditTrail;
    @FindBy(xpath="//a[normalize-space()='Data Entry']") private WebElement menuDataEntry;
    @FindBy(xpath="//a[normalize-space()='Multi Test Point Data Entry']") private WebElement optionMTPDE;
    @FindBy(xpath="//a[normalize-space()='Multi Test Summary Data Entry']") private WebElement optionMTSDE;
    @FindBy(xpath="//a[normalize-space()='Single Test Point Data Entry']") private WebElement optionSTPDE;
    @FindBy(xpath="//a[normalize-space()='Single Test Summary Data Entry']") private WebElement optionSTSDE;
    @FindBy(xpath="//a[normalize-space()='Rules/Settings']" ) private WebElement optionRulesSettings;
    @FindBy(xpath="//a[normalize-space()='Analytical Goals »']") private WebElement configurateOptionAnalyticalGoals;
    @FindBy(css="a[onclick=\"menuClick('ImprecisionBVPage.aspx');\"]") private WebElement optionAGIMPBV;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Menu Configure
    public HomePage selectMenuConfigure(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(menuConfigure));
        e.click();
        return this;
    }

    public LabPage selectLabOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(configureLinkLab));
        e.click();
        return new LabPage(driver);
    }

    public AuditTrailPage navigateToAuditTrail(){
        selectReportOptionAuditTrail();
        return new AuditTrailPage(driver);
    }

    public LotPage selectLotOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(configureLinkLot));
        e.click();
        return new LotPage(driver);
    }

    public TestPage selectTestOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(configureLinkTest));
        e.click();
        return new TestPage(driver);
    }

    public RulesSettingsPage navigateToRulesSettings(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionRulesSettings));
        e.click();
        return new RulesSettingsPage(driver);
    }

//    public MTPDEPage navigateToMTPDE(){
//
//    }

    public HomePage expandPanelOption(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(configurePanelOption));
        e.click();
        return this;
    }

    public PanelAddUpdatePage clickAddPanelOption(){
        WebElement e =  wait.until(ExpectedConditions.visibilityOf(panelOptionAdd));
        e.click();
        return new PanelAddUpdatePage(driver);
    }

    public HomePage clickUpdateSortTest(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(panelOptionUpdateSort));
        e.click();
        return this;
    }

    //Menu Reports
    public HomePage selectMenuReport(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(menuReport));
        e.click();
        return this;
    }

    public AuditTrailPage selectReportOptionAuditTrail(){
        WebElement a = wait.until(ExpectedConditions.visibilityOf(menuReports));
        a.click();
        WebElement e = wait.until(ExpectedConditions.visibilityOf(menuOptionAuditTrail));
        e.click();
        return new AuditTrailPage(driver);
    }

    public void selectMenuDataEntry(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(menuDataEntry));
        e.click();
    }

    public MTPDEPage selectOptionMTPDE(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionMTPDE));
        e.click();
        return new MTPDEPage(driver);
    }

    public MTSDEPage selectOptionMTSDE(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionMTSDE));
        e.click();
        return new MTSDEPage(driver);
    }

    public STPDEPage selectOptionSTPDE(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionSTPDE));
        e.click();
        return new STPDEPage(driver);
    }

    public STSDEPage selectOptionSTSDE(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(optionSTSDE));
        e.click();
        return new STSDEPage(driver);
    }

    public ImprecisionBVPage navigateToAGImprecisionBV(){
        WebElement aG = wait.until(ExpectedConditions.visibilityOf(configurateOptionAnalyticalGoals));
        aG.click();
        WebElement impBV = wait.until(ExpectedConditions.visibilityOf(optionAGIMPBV));
        impBV.click();
        return new ImprecisionBVPage(driver);
    }
}
