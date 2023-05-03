package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsPage extends Base{

    public FlightsPage(WebDriver driver) {
        super(driver);
    }

    public By byFlightsHeader = By.cssSelector("div.container h3");


}
