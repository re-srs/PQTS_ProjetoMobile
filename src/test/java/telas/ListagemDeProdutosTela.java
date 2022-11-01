package telas;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ListagemDeProdutosTela extends BaseTela{

    public ListagemDeProdutosTela(AppiumDriver driver) {
        super(driver);
    }

    public FormularioAdicaoProdutoTela abrirFormularioNovoProduto() {
        driver.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(driver);
    }
}
