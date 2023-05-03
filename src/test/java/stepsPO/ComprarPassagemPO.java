package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.FlightsPage;
import pageObject.HomePage;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComprarPassagemPO {

    private WebDriver driver;
    private HomePage homePage;

    private FlightsPage flightsPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        homePage = new HomePage(driver);

    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("que acesso a pagina inicial")
    public void que_acesso_a_pagina_inicial() {
        driver.get("https://blazedemo.com/");
        String tituloPagina = driver.getTitle();
        assertEquals("BlazeDemo", tituloPagina);
    }

    @When("seleciono origem {string} e destino {string}")
    public void seleciono_origem_e_destino(String origem, String destino) {

        homePage.selecionarOrigemDestino(origem, destino);

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @When("clico no botao Find Flights")
    public void clico_no_botao_find_flights() {
        homePage.clicarBtnFindFlights();
        flightsPage = new FlightsPage(driver);

    }

    @Then("exibe pagina de voos entre {string} e {string} disponiveis")
    public void exibe_pagina_de_voos_entre_e_disponiveis(String origem, String destino) {
        assertEquals("BlazeDemo - reserve", flightsPage.driver.getTitle());
        assertEquals(MessageFormat.format("Flights from {0} to {1}:", origem, destino), driver.findElement(flightsPage.byFlightsHeader).getText());

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
