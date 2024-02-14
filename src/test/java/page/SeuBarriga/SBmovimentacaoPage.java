package page.SeuBarriga;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBmovimentacaoPage extends BasePage {

    public void salvar() throws MalformedURLException {
        clicarPorTexto("SALVAR");
    }
    public void setDescricao(String desc) throws MalformedURLException {
        escrever(By.className("android.widget.EditText"), desc);
    }
    public void setInteressado(String  interessado) throws MalformedURLException {
        escrever(By.xpath("//android.widget.EditText[2]"), interessado);
    }
        public void setValor(String  valor) throws MalformedURLException {
        escrever(By.xpath("//android.widget.EditText[3]"), valor);
    }
    public void setContaSpinner(String conta) throws MalformedURLException{
        selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
    }
}
