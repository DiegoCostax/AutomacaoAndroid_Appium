package test;

import Appium.core.BaseTest;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CliquesPage;
import page.MenuPage;

import java.net.MalformedURLException;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setup() throws MalformedURLException {
        menu.acessarCliques();
    }


    @Test
    public void deveRealizarCliqueLongo() throws MalformedURLException {

        //clique longo
        page.cliqueLongo(); 

        //verificar texto
        Assertions.assertEquals("Clique Longo", page.obterTextoCampo());
    }
    @Test
    public void deveRealizarCliqueDuplo() throws MalformedURLException {
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        Assertions.assertEquals("Duplo Clique", page.obterTextoCampo());

    }
}
