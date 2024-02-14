package page.SeuBarriga;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBmenuPage extends BasePage {

    public void acessarContas() throws MalformedURLException {
        clicarPorTexto("CONTAS");
    }
    public void acessarMov() throws MalformedURLException {
        clicarPorTexto(("MOV..."));
    }
    public void acessarResumo() throws MalformedURLException{
        clicarPorTexto("RESUMO");
    }
    public void acessarHome() throws MalformedURLException{
        clicarPorTexto("HOME");
    }


}

