package page;

import Appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario() throws MalformedURLException {
        clicarPorTexto("Formulário");
    }
    public void acessarSplash() throws MalformedURLException {
        clicarPorTexto("Splash");
    }
    public void acessarAlertas() throws MalformedURLException {
        clicarPorTexto("Alertas");
    }
    public void acessarAbas() throws MalformedURLException{
        clicarPorTexto("Abas");
    }
    public void acessarAccordion() throws MalformedURLException{
        clicarPorTexto("Accordion");
    }
    public void acessarCliques() throws MalformedURLException{
        clicarPorTexto("Cliques");
    }
    public void acessarSwipe() throws MalformedURLException {
        clicarPorTexto("Swipe");
    }
    public void acessarSwipeList() throws MalformedURLException{
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Swipe List");
    }
    public void acessarDragNdrop() throws MalformedURLException{
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }
    public void acessarSBHibrido() throws MalformedURLException {
        clicarPorTexto("SeuBarriga Hibrido");
    }
    public void acessarSBNativo() throws MalformedURLException {
        clicarPorTexto("SeuBarriga Nativo");
    }
}
