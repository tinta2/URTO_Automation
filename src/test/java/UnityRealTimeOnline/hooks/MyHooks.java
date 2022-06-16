package UnityRealTimeOnline.hooks;

import UnityRealTimeOnline.factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyHooks {
    private WebDriver driver;

    @Before
    public void before(Scenario scenario){
        System.out.println("BEFORE: THREAD ID: " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
       // driver = DriverManager.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void after(Scenario scenario) throws IOException {
        System.out.println("AFTER: THREAD ID: " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME : " + scenario.getName());

//        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(sourceFile, new File("C:\\Users\\tguevara\\cucumberDBB\\tguevara.png"));
//        System.out.println( "SCREENSHOT: "  + " C:\\Users\\tguevara\\cucumberBDD");
//        driver.quit();
    }


}
