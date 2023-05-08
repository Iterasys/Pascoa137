package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By byLocal(String local) {
        return By.cssSelector("option[value=\"" + local + "\"]");
    }

    @FindBy(css = "input[value]")
    WebElement btnFindFlights;

    //public By byBtnFindFlights = By.cssSelector("input[value]");


    public void selecionarOrigemDestino(String byOrigem, String byDestino) {
        driver.findElement(byLocal(byOrigem)).click();
        driver.findElement(byLocal(byDestino)).click();
    }

    public void clicarBtnFindFlights() {
        btnFindFlights.click();
    }

    public void acessarHomePage() {
        driver.get("https://blazedemo.com/");
    }
}
