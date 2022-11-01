package telas;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BaseTela {
    protected AppiumDriver driver;

    public BaseTela(AppiumDriver driver){
        this.driver = driver;
    }

    public String capturarToast() {
        return driver.findElement(By.xpath("//android.widget.Toast")).getText();
    }
}
