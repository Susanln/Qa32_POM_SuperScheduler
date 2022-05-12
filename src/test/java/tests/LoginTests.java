package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {
 @Test
    public void loginSuccess(){

     new SplashScreen(driver).checkVersion("0.0.3").fillEmail("asdqw23@gmail.com").fillPassword("Asdqw23$").submitLogin();


 }
@Test
    public void loginSuccessHW(){
     Auth auth= Auth.builder().email("asdqw23@gmail.com").password("Asdqw23$").build();
     new SplashScreen(driver).checkVersion("0.0.3").complexLogin(auth);

     }

}
