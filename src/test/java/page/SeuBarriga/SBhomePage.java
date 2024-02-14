package page.SeuBarriga;

import Appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBhomePage extends BasePage {
    //o Following foi usado para buscar um text View abaixo do TextView da conta
    public String obterSaldoConta(String conta)throws MalformedURLException {
        return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
    }
}
