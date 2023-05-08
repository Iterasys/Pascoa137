package stepsPO;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, // Onde estão os cenarios em Gherkin
        glue = {"steps", "stepsPO"},                       // Onde estão as definições de passos
        dryRun = false,                               // Exibição de log
        monochrome = true                              // Detalhes do log)
)

public class Runner {

}