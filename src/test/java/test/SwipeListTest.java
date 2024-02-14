package test;

import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SwipeListPage;

import java.net.MalformedURLException;

public class SwipeListTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void SwipeList() throws MalformedURLException {
        //clicar no swipe list
        menu.acessarSwipeList();
        //op1 swipe para direita
        page.swipeElementRight("Opção 1");
        //clicar no +
        page.clicarBotaoMais();
        //verificar op1 +
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
        //op4 para a direita
        page.swipeElementRight("Opção 4");
        //clicar no -
        page.clicarPorTexto("(-)");
        //verificar op4 -
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
        //op5 para esquerda
        page.swipeElementLeft("Opção 5 (-)");
        //verificar op5
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 5"));
    }
}
