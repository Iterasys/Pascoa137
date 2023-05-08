package stepsPO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.Base;
import pageObject.FlightsPage;
import pageObject.HomePage;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComprarPassagemPO{

    final WebDriver driver;
    private FlightsPage flightsPage;
    private HomePage homePage;

    public ComprarPassagemPO(Base base) {
        this.driver = base.driver;
    }

    @Given("que acesso a pagina inicial PO")
    public void que_acesso_a_pagina_inicial() {

        homePage = new HomePage(driver);

        homePage.acessarHomePage();
        String tituloPagina = homePage.getTitle();
        assertEquals("BlazeDemo", tituloPagina);
    }

    @When("seleciono origem {string} e destino {string} PO")
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

    @When("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights() {
        homePage.clicarBtnFindFlights();
        flightsPage = new FlightsPage(driver);

    }

    @Then("exibe pagina de voos entre {string} e {string} disponiveis PO")
    public void exibe_pagina_de_voos_entre_e_disponiveis(String origem, String destino) {
        assertEquals("BlazeDemo - reserve", flightsPage.getTitle());
        assertEquals(MessageFormat.format("Flights from {0} to {1}:", origem, destino), flightsPage.getFlightsHeader());

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
