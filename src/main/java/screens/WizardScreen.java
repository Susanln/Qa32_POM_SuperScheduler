package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WizardScreen extends BaseScreen{

    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipButton;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_title']")
    MobileElement setDataText;
    @FindBy(xpath = "com.example.svetlana.scheduler:id/wizard_settings_prior_txt")
    MobileElement Text;
    public HomeScreen skipWizard(){
        should(skipButton,15);
        skipButton.click();
        return new HomeScreen(driver);
    }
    public HomeScreen skipIfWizard(){
        pause(1000);
        if(driver.findElements(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_title']")).size()>0)
        {
            skipButton.click();
        }
        return new HomeScreen(driver);
    }
}
