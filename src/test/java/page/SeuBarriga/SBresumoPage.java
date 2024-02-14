package page.SeuBarriga;

import Appium.core.BasePage;
import Appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class SBresumoPage extends BasePage {

    public void excluirMovimentacao(String desc) throws MalformedURLException {
        MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
        swipeElement(el, 0.9, 0.1);
        clicarPorTexto("Del");
    }
}
