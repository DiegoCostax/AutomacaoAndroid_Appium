package Appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import  org.openqa.selenium.OutputType;
import  org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse() {
        DriverFactory.killDriver();
    }

    @After
    public void tearDown() throws MalformedURLException {
        gerarScreenShot();
       DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot() throws MalformedURLException {

        File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs((OutputType.FILE));
        try {
            FileUtils.copyFile(imagem, new File("target/screenshots/" + testName.getMethodName() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


