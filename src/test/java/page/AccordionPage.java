package page;

import Appium.core.BasePage;

import java.net.MalformedURLException;

public class AccordionPage extends BasePage {
    public void clicarNaOpcao() throws MalformedURLException {
        clicarPorTexto("Opção 1");
    }


    public boolean verificarTexto(String texto) throws MalformedURLException {
        return existeElementoPorTexto(texto);
    }
}
