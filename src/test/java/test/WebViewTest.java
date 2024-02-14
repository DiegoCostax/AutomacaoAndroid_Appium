package test;

import Appium.core.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.WebViewPage;

import java.net.MalformedURLException;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin() throws MalformedURLException {
        //acessar o menu
        menu.acessarSBHibrido();
        esperar(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("diegoteste@gmail.com");

        //senha
        page.setSenha("teste123");

        //entrar
        page.entrar();

        //verificar
        Assert.assertEquals("Bem vindo, Diego!", page.getMensagem());
    }

    @After
    public void tearDown() throws MalformedURLException {
        page.sairContextoWeb();
    }
}


