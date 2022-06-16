package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_GridViewInstrumentTests_ctl03_ToCreate") private WebElement checboxTest;
    @FindBy(css="#ctl00_HyperLinkLogout") private WebElement linkLogOut;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public TestPage selectTest(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(checboxTest));
        e.click();
        return new TestPage(driver);
    }

    public void clickLogOut(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(linkLogOut));
        e.click();
    }




}
