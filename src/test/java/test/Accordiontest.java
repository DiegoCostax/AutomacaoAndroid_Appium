package test;

import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.AccordionPage;
import page.MenuPage;

import java.net.MalformedURLException;

public class Accordiontest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();


    @Test
    public void interagirComAccordion() throws MalformedURLException {
        //acessar Menu
        menu.acessarAccordion();

        //clicar op 1
        page.clicarNaOpcao();

        //verificar texto op 1
        Assertions.assertTrue(page.existeElementoPorTexto("Esta é a descrição da opção 1"));
    }
}
