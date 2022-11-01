package telas;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginTela extends BaseTela{


    public LoginTela(AppiumDriver driver) {
        super(driver);
    }

    public LoginTela preencherUsuario (String usuario) {
        driver.findElement(By.id("com.lojinha:id/user")).click();
        driver.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);
        return this;
    }

    public LoginTela preencherSenha (String senha) {
        driver.findElement(By.id("com.lojinha:id/password")).click();
        driver.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);
        return this;
    }

    public ListagemDeProdutosTela submeterLogin () {
        driver.findElement(By.id("com.lojinha:id/loginButton")).click();
        return new ListagemDeProdutosTela(driver);

    }


}
