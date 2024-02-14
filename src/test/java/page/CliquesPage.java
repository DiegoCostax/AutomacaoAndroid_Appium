package page;

import Appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {


    public void cliqueLongo() throws MalformedURLException {
        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));

    }

    public String obterTextoCampo() throws MalformedURLException {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

}


