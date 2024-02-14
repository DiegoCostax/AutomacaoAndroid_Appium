package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ScreenLogin {
        public  ScreenLogin(AppiumDriver<MobileElement> driver){
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }
}
