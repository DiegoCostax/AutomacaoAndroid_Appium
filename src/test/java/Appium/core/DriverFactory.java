package Appium.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        if (driver == null){
            createDriver();
        }
            return driver;
    }

    private Assertions Assert;

    @BeforeAll
    public static void createDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "bcc930dd");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");
        desiredCapabilities.setCapability("noReset", true);


        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
