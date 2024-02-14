package test;

import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MenuPage;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebDriver getDriver;

    @Test
    public void deveEncontrarOpcaoEscondida() throws MalformedURLException {
        //Scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        menu.scrollDown();

        menu.clicarPorTexto("Opção bem escondida");
        //verificar mensagem
        Assertions.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
        //sair da mensagem
        menu.clicarPorTexto("OK");

    }


}
