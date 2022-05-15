package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.AuthProvider;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement  burgerMenu;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/group_events_menu']")
    MobileElement eventsButton;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement addSchedule;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout_container']")
    MobileElement logout;

    public boolean isFabPlusPresent() {
        pause(1000);
        if(driver.findElements(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")).size()>0) {
            should(addSchedule, 15);
            return addSchedule.isDisplayed();
        }
        return false;
    }

   public HomeScreen openMenu(){
        should(burgerMenu,10);
        burgerMenu.click();
        return new HomeScreen(driver);
   }
   public LoginScreen logout(){
        logout.click();
        return new LoginScreen(driver);
   }

    public HomeScreen checkFabButtonPresent() {
        should(addSchedule,10);
        Assert.assertTrue(addSchedule.isDisplayed());
        return this;
    }
}
