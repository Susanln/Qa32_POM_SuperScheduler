package tests;

import configuration.AppiumConfiguration;
import configuration.ListenerTest;
import models.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
@Listeners(ListenerTest.class)
public class LoginTests extends AppiumConfiguration {
    Logger logger = LoggerFactory.getLogger(LoginTests.class);

    @Test
    public void loginSuccess(){

     boolean isFabButtonPresent = new LoginScreen(driver).fillEmail("asdqw23@gmail.com").fillPassword("Asdqw23$").submitLogin().isFabPlusPresent();
     Assert.assertTrue(isFabButtonPresent);


 }
@Test
    public void loginSuccessHW(){
     Auth auth= Auth.builder().email("asdqw23@gmail.com").password("Asdqw23$").build();
    boolean isFabButtonPresent =new LoginScreen(driver).complexLogin(auth).isFabPlusPresent();
    Assert.assertTrue(isFabButtonPresent);
    logger.info("Test start with data--->"+ auth.toString());

     }
    @Test
    public void loginSuccess1(){
        Auth auth= Auth.builder().email("asdqw23@gmail.com").password("Asdqw23$").build();
      new LoginScreen(driver).complexLogin(auth).checkFabButtonPresent();
        logger.info("Test start with data--->"+ auth.toString());

    }
    @Test
    public void loginCheckErrorMessage(){
     new LoginScreen(driver).complexUnsuccess(Auth.builder().email("asdqw23@gmail.com").password("Asdqw123$").build()).submitLoginError();


    }
    @AfterMethod
    public void postCondition(){
     if(new HomeScreen(driver).isFabPlusPresent())
     {
     new HomeScreen(driver).openMenu().logout();}
    }
}
