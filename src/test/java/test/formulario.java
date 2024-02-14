package test;

import Appium.core.BaseTest;
import Appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FormularioPage;
import page.MenuPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class formulario extends BaseTest {

    private Assertions Assert;

    

    private static MenuPage menu = new MenuPage();
    private static FormularioPage page = new FormularioPage();

    @BeforeAll
    public static void inicializarAppium() throws MalformedURLException {

        menu.acessarFormulario();
    }


    @Test
    @Order(1)
    public void devePreencherCampoTexto() throws MalformedURLException {


        //Escrever o nome
        page.escreverNome("Diego");


       //Checar nome escrito
        assertEquals("Diego", page.obterNome());

    }


    @Test
    @Order(4)
    public void deveInteragirCombo() throws MalformedURLException {



        //Clicar no combo
        page.selecionarCombo("Nintendo Switch");

        //Verificar opcao selecionada
        assertEquals("Nintendo Switch", page.obterValorCombo());

    }
    @Test
    @Order(2)
    public void deveInteragirSwitch() throws MalformedURLException {


        //Verificar status dos elementos

        Assertions.assertFalse(page.isCheckMarcado());
        Assertions.assertTrue(page.isSwitchMarcado());
        //Clicar nos elementos
        page.clicarCheck();
        page.clicarSwitch();

        //Verificar estados alterados
        Assertions.assertTrue(page.isCheckMarcado());
        Assertions.assertFalse(page.isSwitchMarcado());
    }
    @Test
    @Order(3)
    public void desafioCurso() throws MalformedURLException  {

        //Escrever o campo nome
        page.escreverNome("Diego");
        page.clicarCheck();
        page.clicarSwitch();
        page.selecionarCombo("Nintendo Switch");

        //Salvar
        page.clicarPorTexto("SALVAR");

        //Verificações

        assertEquals("Nome: Diego", page.obterNomeCadastrado());
        assertEquals("Console: switch",page.obterConsoleCadastrado());
        Assertions.assertFalse(page.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]")).endsWith("Off"));
        Assertions.assertFalse(page.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).endsWith("Marcado"));

    }
    @Test
    @Order(5)
    public void desafioCursoDemorado() throws MalformedURLException  {

        //Escrever o campo nome
        page.escreverNome("Diego");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        page.salvarDemorado();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Diego']")));
        assertEquals("Nome: Diego", page.obterNomeCadastrado());
    }
    @Test
    public void deveAlterarData() throws MalformedURLException {
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assertions.assertTrue(page.existeElementoPorTexto("20/2/2000"));
    }
    @Test
    public void deveAlterarHora() throws MalformedURLException {
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        Assertions.assertTrue(page.existeElementoPorTexto("10:40"));
    }
    @Test
    public void deveInteragirComSeekbar() throws MalformedURLException {
        //Clicar no Seekbar
        page.clicarSeekBar(0.50);
        //Salvar
        page.salvar();

        //Obter o valor


    }
}