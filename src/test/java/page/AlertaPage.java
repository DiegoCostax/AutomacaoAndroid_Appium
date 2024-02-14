package page;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AlertaPage extends BasePage {
    public void clicarAlertaConfirm() throws MalformedURLException {
        clicarPorTexto("ALERTA CONFIRM");
    }
    public void clicarAlertaSimples() throws MalformedURLException {
            clicarPorTexto("ALERTA SIMPLES");
    }


    public void confirmar() throws MalformedURLException {
        clicarPorTexto("CONFIRMAR");
    }
    public void sair() throws MalformedURLException {
        clicarPorTexto("SAIR");
    }
    public void clicarForaCaixa() throws MalformedURLException {
         tap(100, 150);
    }

}
