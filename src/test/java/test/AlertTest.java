package test;

import Appium.core.BaseTest;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.AlertaPage;
import page.MenuPage;

import java.net.MalformedURLException;

public class AlertTest extends BaseTest {

    @Before
    public void setup() throws MalformedURLException {
        //acessar menu alerta
            menu.acessarAlertas();
    }

    private  MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();
    @Test
    public void deveConfirmarAlerta() throws MalformedURLException {
        //Acessar menu alerta
        menu.acessarAlertas();
        //Clicar em alerta connfirm
        page.clicarAlertaConfirm();
        //Verificar os textos
        Assertions.assertEquals("Info", page.obterTituloAlerta());
        Assertions.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
        //confirmar o alerta
        page.confirmar();

        //Verificar no mensagem
        Assertions.assertEquals("Confirmado", page.obterMensagemAlerta());

        //sair
        page.sair();
    }
    @org.junit.Test
    public void deveClicarForaAlerta() throws MalformedURLException {

        //clicar alerta simples
        page.clicarAlertaSimples();
        //clicar fora da caixa
        esperar(1000);
        page.clicarForaCaixa();
        //verificar que a mensagem não esta presente
        Assertions.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa pra sair"));
    }
}
