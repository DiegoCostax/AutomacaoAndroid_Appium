package test;

import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MenuPage;

import java.net.MalformedURLException;

public class SwipeTest extends BaseTest {

    MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe() throws MalformedURLException {
        //acessar Menu
        menu.acessarSwipe();
        //verificar o texto 'a esquerda'
        Assertions.assertTrue(menu.existeElementoPorTexto("a esquerda"));
        //swipe para direita
        menu.swipeRight();

        // verificar texto 'E veja se'
        Assertions.assertTrue(menu.existeElementoPorTexto("E veja se"));
        esperar(5000);
        //clicar botão direita
        menu.clicarPorTexto(">");

        //verificar texto 'Chegar ate o fim!'
        Assertions.assertTrue(menu.existeElementoPorTexto("Chegar ate o fim!"));
        //swipe esquerdo
        menu.swipeLeft();
        //clicar botão esquerdo
        menu.clicarPorTexto("<");
        //verificar o texto 'a esquerda'
        Assertions.assertTrue(menu.existeElementoPorTexto("a esquerda"));





    }
}
