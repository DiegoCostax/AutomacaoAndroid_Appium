package page;

import Appium.core.BasePage;
import Appium.core.DriverFactory;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Set;

import static Appium.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

        public void entrarContextoWeb() throws MalformedURLException {
            Set<String> contextHandles = getDriver().getContextHandles();
            for(String valor: contextHandles) {
                System.out.println(valor);
            }
            getDriver().context((String)contextHandles.toArray()[1]);
        }

        public void setEmail(String valor) throws MalformedURLException {
            getDriver().findElement(By.id("email")).sendKeys(valor);
        }

        public void setSenha(String senha) throws MalformedURLException {
            getDriver().findElement(By.id("senha")).sendKeys(senha);
        }

        public void entrar() throws MalformedURLException {
            clicar(By.xpath("//button[@type='submit']"));
        }

        public String getMensagem() throws MalformedURLException {
            return obterTexto(By.xpath("//div[@class='alert alert-success']"));
        }

        public void sairContextoWeb() throws MalformedURLException {
            getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
        }
    }


