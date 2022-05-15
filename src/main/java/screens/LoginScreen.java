package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginScreen extends BaseScreen{

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okButton;
    public LoginScreen fillEmail(String email){
        should(emailEditText,15);
        type(emailEditText,email);
        return this;
    }
    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }
    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }
    public HomeScreen complexLogin(Auth auth){
        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        should(passwordEditText,15);
        type(passwordEditText,auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }
    public WizardScreen complexRegistration(Auth auth){
        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        should(passwordEditText,15);
        type(passwordEditText,auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public WizardScreen complex(Auth auth){
        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        should(passwordEditText,15);
        type(passwordEditText,auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public LoginScreen complexUnsuccess(Auth auth){
        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        should(passwordEditText,15);
        type(passwordEditText,auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return this;
    }

    public LoginScreen submitLoginError() {
        should(errorMessage,15);
        Assert.assertEquals(errorMessage.getText(),"Wrong email or password");
        okButton.click();
        return this;
    }
}
