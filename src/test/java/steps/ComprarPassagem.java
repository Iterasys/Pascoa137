package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.Base;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComprarPassagem {
    final WebDriver driver;

    public ComprarPassagem(Base base) {
        this.driver = base.driver;
    }

    @Given("que acesso a pagina inicial")
    public void que_acesso_a_pagina_inicial() {
        driver.get("https://blazedemo.com/");
        String tituloPagina = driver.getTitle();
        assertEquals("BlazeDemo", tituloPagina);
    }

    @When("seleciono origem {string} e destino {string}")
    public void seleciono_origem_e_destino(String origem, String destino) {
        final String byOrigem = "option[value=\"" + origem + "\"]";
        final String byDestino = "option[value=\"" + destino + "\"]";

        driver.findElement(By.cssSelector(byOrigem)).click();
        driver.findElement(By.cssSelector(byDestino)).click();

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
        driver.findElement(By.cssSelector("input[value]")).click();
    }

    @Then("exibe pagina de voos entre {string} e {string} disponiveis")
    public void exibe_pagina_de_voos_entre_e_disponiveis(String origem, String destino) {
        assertEquals("BlazeDemo - reserve", driver.getTitle());
        assertEquals(MessageFormat.format("Flights from {0} to {1}:", origem, destino), driver.findElement(By.cssSelector("div.container h3")).getText());

        synchronized (driver) {
            try {
                driver.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
