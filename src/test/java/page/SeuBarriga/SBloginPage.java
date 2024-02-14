package page.SeuBarriga;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBloginPage extends BasePage {


    public void setNome(String email) throws MalformedURLException {
        escrever(By.className("android.widget.EditText"), email);
    }
    public void setSenha(String senha) throws MalformedURLException{
        escrever(By.xpath("//android.widget.EditText[2]"), senha);
    }
    public void entrar() throws MalformedURLException {
        clicarPorTexto("ENTRAR");
    }
}
