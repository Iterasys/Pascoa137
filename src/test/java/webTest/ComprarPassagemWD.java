//  0 - Pacote
package webTest;
// 1 - Bibliotecas

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2 - Classe
public class ComprarPassagemWD { // inicio da classe
    // 2.1 - Atributos
    private WebDriver driver; // declaramos o objeto do Selenium WebDriver

    // 2.2 - Funções e Métodos

    // Antes do Teste
    @BeforeEach
    public void setUp(){ // inicio do Before
        // declarar o gerenciador para baixar o chrome driver
        WebDriverManager.chromedriver().setup();
        // configuração especifica a partir do Selenium WebDriver 4.8.1
        ChromeOptions options = new ChromeOptions(); // instancia o ChromeOptions
        // Adicionou ao ChromeOptions a opção de permitir qualquer origem de
        // acesso remoto
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // instancia o Chrome Driver com Options
        driver.manage().window().maximize(); // maximiza a janela do navegador

    } // fim do Before

    // Depois do Teste
    @AfterEach
    public void tearDown(){ //inicio do After
        driver.quit(); // destroi a instancia do Selenium WebDriver
    } // fim do After

    // O Teste
    @Test
    public void comprarPassagemWD(){ //inicio do comprarPassagem
        driver.get("https://www.blazedemo.com"); // abre o endereço alvo
        // selecionar a lista/combo de cidades de origem
        driver.findElement(By.name("fromPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("fromPort"));
            lista.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        } //fim da seleção dentro da lista

        driver.findElement(By.name("toPort")).click();
        // selecionar a cidade na lista
        { //inicio da seleção dentro da lista
            WebElement lista = driver.findElement(By.name("toPort"));
            lista.findElement(By.xpath("//option[. = 'Berlin']")).click();
        } //fim da seleção dentro da lista

        // apertar o botão Find Flights
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // validar a frase que indica que o vôo é de São Paolo para Berlin
        assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());



    } // fim do comprarPassagem



} // fim da classe
