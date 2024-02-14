package test;

import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.AbasPage;
import page.MenuPage;

import java.net.MalformedURLException;


public class AbasTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage page = new AbasPage();


    @Test
    public void deveInteragirComAbas() throws MalformedURLException {
        //acessar menu abas
        menu.acessarAbas();
        //verificar que esta na aba 1
        Assertions.assertTrue(page.validarAba1());
        //acessar aba 2
        page.entrarAba2();
        //verificar que esta na aba 2
        Assertions.assertTrue(page.validarAba2());
    }
}
