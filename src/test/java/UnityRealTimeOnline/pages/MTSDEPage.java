package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MTSDEPage extends BasePage {
    @FindBy(css="#ctl00_ContentPlaceHolder1_GridViewLLTSummary_ctl01_TableCellEnteredDate")
        private WebElement mtspdeHeaderDate;
    public MTSDEPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderDate(){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(mtspdeHeaderDate));
        return e.getText();
    }

}
