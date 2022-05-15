package screens;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;
    public BaseScreen(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void type(MobileElement element,String text)
    {
        if(text!=null)
        {
            element.click();
            element.clear();
            element.sendKeys(text);

        }
    }
    public void pause(int milles){
        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void should(MobileElement element, int time){
        new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
    }
    public void shouldHave(MobileElement element, int time, String text)
    {
        new WebDriverWait(driver,time).until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public void takeScreenShot(String pathToFile){
        File tmp=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
