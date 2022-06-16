package UnityRealTimeOnline.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static WebDriver driver;
    String browser = System.getProperty("browser");

    public static WebDriver initializeDriver(String browser){
//        WebDriver driver;
        switch (browser){
            case "chrome" -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                ChromeOptions handlingSSL = new ChromeOptions();
                handlingSSL.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(handlingSSL);
                driverSettings(driver);
                break;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driverSettings(driver);
                break;
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", "C:\\Softwares\\edgedriver_win64\\msedgedriver.exe");
                ChromeOptions handlingSSL = new ChromeOptions();
                handlingSSL.setAcceptInsecureCerts(true);
                driver = new EdgeDriver();
                driverSettings(driver);
                break;
            }
            default -> throw new IllegalStateException("INVALID BROWSER " + browser);
        }
//        DriverManager.driver.set(driver);

        return driver;
    }

    public static WebDriver getDriver(){
        initializeDriver("chrome");
       // initializeDriver("firefox");
        //return driver.get();
        return driver;
    }

    private static void driverSettings(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
