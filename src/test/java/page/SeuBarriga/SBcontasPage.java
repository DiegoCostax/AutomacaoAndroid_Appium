package page.SeuBarriga;

import Appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class SBcontasPage extends BasePage {
    public void setConta(String nome) throws MalformedURLException {
        escrever(By.className("android.widget.EditText"), nome);
    }
    public void salvar () throws MalformedURLException{
        clicarPorTexto("SALVAR");
    }
    public void excluir () throws MalformedURLException{
        clicarPorTexto("EXCLUIR");
    }
    public void selecionarConta(String conta) throws MalformedURLException {
        cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }


}
