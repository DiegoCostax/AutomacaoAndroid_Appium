package page;

import Appium.core.BasePage;
import Appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Appium.core.DriverFactory.getDriver;

public class FormularioPage extends BasePage {


        public void escreverNome(String nome) throws MalformedURLException {
            escrever(MobileBy.AccessibilityId("nome"), nome);
        }

        public String obterNome() throws MalformedURLException {
            return  obterTexto(MobileBy.AccessibilityId("nome"));
        }
        public void selecionarCombo(String valor) throws MalformedURLException {
            selecionarCombo(MobileBy.AccessibilityId("console"), valor);

        }
        public String obterValorCombo() throws MalformedURLException {
          return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));

        }
        public void clicarCheck() throws MalformedURLException {
            clicar(By.className("android.widget.CheckBox"));
        }
        public void clicarSwitch() throws MalformedURLException {
            clicar(MobileBy.AccessibilityId("switch"));
        }
        public Boolean isCheckMarcado() throws MalformedURLException {
            return isCheckMarcado(By.className("android.widget.CheckBox"));
        }
        public Boolean isSwitchMarcado() throws MalformedURLException {
           return isCheckMarcado(MobileBy.AccessibilityId("switch"));
        }
        public void clicarSeekBar( double posicao) throws MalformedURLException {
            int delta = 50;
           MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
           int y = seek.getLocation().y + (seek.getSize().height / 2);

           int xinicial = seek.getLocation().x + delta;
           int x = (int) (xinicial + ((seek.getSize().width - 2*delta)  * posicao));

           tap(x, y);
        }
        public void salvar() throws MalformedURLException {
            clicarPorTexto("SALVAR");
        }
    public void salvarDemorado() throws MalformedURLException {
        clicarPorTexto("SALVAR DEMORADO");
    }
        public String obterNomeCadastrado() throws MalformedURLException {
            return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
        }

        public String obterConsoleCadastrado() throws MalformedURLException {
           return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        }
        public String obterCheckCadastrado() throws MalformedURLException {
            return  obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
        }
        public String  obterSwitchCadastrado() throws MalformedURLException {
           return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
        }
}



