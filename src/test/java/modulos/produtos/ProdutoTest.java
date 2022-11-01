package modulos.produtos;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import telas.FormularioAdicaoProdutoTela;
import telas.LoginTela;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@DisplayName("Testes Mobile do Modulo de Produtos")
public class ProdutoTest {

    private AppiumDriver driver;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        //Abrir o app
        // File apk = new File("C:\\Users\\renat\\IdeaProjects\\lojinhaMobileAutomacao\\src\\main\\resources\\lojinha-nativa.apk");
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability(MobileCapabilityType.APP, "C:\\Users\\renat\\IdeaProjects\\lojinhaMobileAutomacao\\src\\main\\resources\\lojinha-nativa.apk");
        capacidades.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidades.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(urlConexao, capacidades);

    }


    @DisplayName("Validacao de Valor de Produto Nao Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() throws InterruptedException {

        //WebDriverWait wait = new WebDriverWait(driver, 5);

        String mensagemApresentada = new LoginTela(driver).preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirFormularioNovoProduto()
                .preencherProduto("Iphone")
                .preencherValorProduto("700001")
                .preencherCorProduto("preto, cinza")
                .submissaoComErro()
                .obterMensagemErro();
        //validar que a mensagem de valor invalido foi apresentada
        Thread.sleep(2000);

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    @AfterEach
    public void afterEach() {
        driver.quit();

    }
}
