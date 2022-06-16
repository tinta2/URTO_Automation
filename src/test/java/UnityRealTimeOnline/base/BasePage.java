package UnityRealTimeOnline.base;

import UnityRealTimeOnline.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);

    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() +  endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> ovelays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: " + ovelays.size());
        if(ovelays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(ovelays));
            System.out.println("OVERLAY INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }



}
