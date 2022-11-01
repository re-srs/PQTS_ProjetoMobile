package telas;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FormularioAdicaoProdutoTela extends BaseTela{


    public FormularioAdicaoProdutoTela(AppiumDriver driver) {
        super(driver);
    }

    public FormularioAdicaoProdutoTela preencherProduto(String produto) {
        driver.findElement(By.id("com.lojinha:id/productName")).click();
        driver.findElement(By.id("com.lojinha:id/editText")).sendKeys(produto);
        return this;
    }
    public FormularioAdicaoProdutoTela preencherValorProduto(String valor) {
        driver.findElement(By.id("com.lojinha:id/productName")).click();
        driver.findElement(By.id("com.lojinha:id/editText")).sendKeys(valor);
        return this;
    }

    public FormularioAdicaoProdutoTela preencherCorProduto(String cor) {
        driver.findElement(By.id("com.lojinha:id/productName")).click();
        driver.findElement(By.id("com.lojinha:id/editText")).sendKeys(cor);
        return this;
    }
    public FormularioAdicaoProdutoTela submissaoComErro(){
        driver.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;

    }

    public String obterMensagemErro() {
        return capturarToast();

    }
}
