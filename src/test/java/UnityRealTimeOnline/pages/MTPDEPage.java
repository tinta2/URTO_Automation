package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MTPDEPage extends BasePage {
    @FindBy(xpath="//td[normalize-space()='Date']") private WebElement mtpdeheaderDate;

    public MTPDEPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderForDate(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(mtpdeheaderDate));
        return e.getText();
    }
}
