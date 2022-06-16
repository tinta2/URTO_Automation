package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class STSDEPage extends BasePage {
    @FindBy(xpath="//td[contains(text(),'Date & Time')]") private WebElement headerSTSDE;

    public STSDEPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderDate(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(headerSTSDE));
        return e.getText();
    }
}
