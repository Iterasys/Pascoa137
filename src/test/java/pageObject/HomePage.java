package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By byLocal(String local) {
        return By.cssSelector("option[value=\"" + local + "\"]");
    }

    public By byBtnFindFlights = By.cssSelector("input[value]");


    public void selecionarOrigemDestino(String byOrigem, String byDestino) {
        this.driver.findElement(byLocal(byOrigem)).click();
        this.driver.findElement(byLocal(byDestino)).click();
    }

    public void clicarBtnFindFlights() {
        this.driver.findElement(byBtnFindFlights).click();
    }
}
