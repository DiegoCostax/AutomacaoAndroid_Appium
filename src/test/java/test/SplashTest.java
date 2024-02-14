package test;
import Appium.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SplashPage;

import java.net.MalformedURLException;


public class SplashTest extends BaseTest {

    public MenuPage menu = new MenuPage();
    private Assertions Assert;
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() throws MalformedURLException {
        //Acessar menu Splash
        menu.acessarSplash();
        //verificar que o splash esta sendo exibido
        page.isTelaSplashVisivel();
        //aguardar saida do splash
        page.aguardarSplashSumir();
        //verificar que o formulario esta aparecendo
        Assertions.assertTrue(page.existeElementoPorTexto("Formulário"));
    }

}
