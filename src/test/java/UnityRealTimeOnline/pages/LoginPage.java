package UnityRealTimeOnline.pages;

import UnityRealTimeOnline.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(css = "#TextBoxUser") private WebElement loginUserTextBoxFld;
    @FindBy(css = "#TextBoxPassword") private WebElement loginPasswordTestBoxFld;
    @FindBy(css = "#ButtonLogin") private WebElement loginBtn;
    @FindBy(css= "#ctl00_HyperLinkLogout") private WebElement loginlogoutUserlink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterLoginUser(String loginUser){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(loginUserTextBoxFld));
        e.click();
        e.clear();
        e.sendKeys(loginUser);
        return this;
    }

    public LoginPage enterLoginPassword(String loginPassword){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(loginPasswordTestBoxFld));
        e.click();
        e.clear();
        e.sendKeys(loginPassword);
        return this;
    }

    public LoginPage setLoginDetails(String loginUser, String loginPassword){
        return enterLoginUser(loginUser).
                enterLoginPassword(loginPassword);
    }
    public void loginBtnClick(){
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
    }

    public String getlogoutUser(){
        return wait.until(ExpectedConditions.visibilityOf(loginlogoutUserlink)).getText();
    }

    public void login(String user, String password){
        enterLoginUser(user);
        enterLoginPassword(password);
        loginBtnClick();
    }
}

