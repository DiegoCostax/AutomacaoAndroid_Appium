package page;

import Appium.core.BasePage;
import Appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft( String opcao) throws MalformedURLException {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }
    public void swipeElementRight( String opcao) throws MalformedURLException {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
    }
    public void clicarBotaoMais( )throws MalformedURLException{
        WebElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
        tap(botao.getLocation().getX() + 50, botao.getLocation().getY());
    }

}
