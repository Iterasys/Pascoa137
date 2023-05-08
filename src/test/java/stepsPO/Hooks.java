package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.Base;

import java.util.concurrent.TimeUnit;

public class Hooks{

    Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void iniciarPO() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        base.driver = new ChromeDriver(options);
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @After
    public void finalizarPO() {
        base.driver.quit();
    }
}
