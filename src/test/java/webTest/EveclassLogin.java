package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EveclassLogin {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        wait = new WebDriverWait(driver, Duration.ofMillis(5000));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testeLogin() {
        driver.get("https://testando.eveclass.com/pt");
        driver.findElement(By.id("support-action")).click();
        driver.navigate().refresh();

        // Cabeçalho "Entrar"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-header h1")));

        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("correia@iterasys.com.br");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Z0br3M@drugar");


        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
