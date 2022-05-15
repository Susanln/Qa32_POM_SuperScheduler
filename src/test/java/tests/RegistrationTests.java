package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends AppiumConfiguration {
    Logger logger = LoggerFactory.getLogger(LoginTests.class);
    @Test
    public void registrationSuccess(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        Auth auth = Auth.builder().email("asdqw23"+ i +"@gmail.com").password("Asdqw23$").build();
       new LoginScreen(driver)
                .complexRegistration(auth)
                        .skipWizard().checkFabButtonPresent()
              .openMenu().logout();
        logger.info("Test start with data--->"+ auth.toString());
    }
    @Test
    public void loginRegistrationSuccess(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        Auth auth = Auth.builder().email("asdqw23"+ i +"@gmail.com").password("Asdqw23$").build();
        new LoginScreen(driver).complex(auth)
                .skipIfWizard()
                .checkFabButtonPresent()
                .openMenu().logout();
        logger.info("Test start with data--->"+ auth.toString());
    }

}
