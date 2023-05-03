package pageObject;

import org.openqa.selenium.WebDriver;

public class Base {

    public WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }
}
