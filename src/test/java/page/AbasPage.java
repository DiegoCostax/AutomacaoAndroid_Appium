package page;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AbasPage extends BasePage {

    public boolean validarAba1() throws MalformedURLException {
      return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }
    public void entrarAba2() throws MalformedURLException{
        clicarPorTexto("ABA 2");
    }
    public boolean validarAba2() throws MalformedURLException {
       return existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }
}
