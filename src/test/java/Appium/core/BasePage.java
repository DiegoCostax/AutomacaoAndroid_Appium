package Appium.core;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static Appium.core.DriverFactory.getDriver;

public class BasePage {
    public void escrever(By by, String texto) throws MalformedURLException {
        getDriver().findElement(by).sendKeys(texto);

    }

    public String obterTexto(By by) throws MalformedURLException {
        return getDriver().findElement(by).getText();
    }

    public void selecionarCombo(By by, String valor) throws MalformedURLException {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public void clicar(By by) throws MalformedURLException {
        getDriver().findElement(by).click();

    }

    public void clicarPorTexto(String texto) throws MalformedURLException {
        clicar(By.xpath("//*[@text='" + texto + "']"));
    }

    public boolean isCheckMarcado(By by) throws MalformedURLException {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) throws MalformedURLException {
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
    }

    public void tap(int x, int y) throws MalformedURLException {
        TapOptions options = new TapOptions();
        options.withPosition(PointOption.point(x, y));
        new TouchAction(getDriver()).tap(options).perform();
    }
    public void scrollDown() throws MalformedURLException {
        scroll(0.9, 0.1);
    }
    public void scrollUp() throws MalformedURLException {
        scroll(0.1, 0.9);
    }
    public void swipeLeft() throws MalformedURLException {
        swipe(0.1, 0.9);
    }
    public void swipeRight() throws MalformedURLException{
        swipe(0.9, 0.1);
    }


    public void scroll(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        genericSwipe(x, start_y, x, end_y);
    }

    {
    }
    public void genericSwipe(int startX, int startY, int endX, int endY) throws MalformedURLException {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
                        startX, startY))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(FINGER, Duration.ofMillis(500)))
                .addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
                        endX, endY))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(drag));
    }
    public String obterTituloAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/alertTitle"));
    }
    public String obterMensagemAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/message"));

    }
    public void swipe(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height/ 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        genericSwipe(start_x, y, end_x, y);
    }
    public void swipeElement(MobileElement element, double inicio, double fim) throws MalformedURLException {

        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        genericSwipe(start_x, y, end_x, y);
    }
    public void cliqueLongo(By by) throws MalformedURLException {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) getDriver().findElement(by)).getId(),
                "duration", 1000
        ));
    }


}


