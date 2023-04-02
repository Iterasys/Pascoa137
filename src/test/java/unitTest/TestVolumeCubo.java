package unitTest;
// bibliotecas necessarias para usar nos testes
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.Assert.assertEquals;


public class TestVolumeCubo {

    @Test
    @Order(1)
    public void testCalcularVolumeCubo() {
        // Define a aresta do cubo
        // Configura
        double comprimentoAresta = 5.0;

        // Co cálculo do volume do cubo pode ser feito multiplicando o comprimento da aresta
        // por si mesma três vezes, ou seja, volume = comprimentoAresta * comprimentoAresta * comprimentoAresta.
        // Mas para simplificar o código e evitar repetições, é comum usar o método pow para calcular a potência
        // do número.
        //Executa
        double volumeCalculado = Math.pow(comprimentoAresta, 3);

        // Define o resultado esperado
        double resultadoEsperado = 125.0;

        // Este código está usando o método "assertEquals" para verificar se o volume calculado de um
        // cubo está correto.
        //0.0001: a margem de erro permitida para a comparação dos valores esperado e calculado.
        //Valida
        assertEquals(resultadoEsperado, volumeCalculado, 0.0001);

    }
    @ParameterizedTest
    @CsvSource(value = {
            "5.0,3,125",
            "6.0,3,216",
            "7.0,3,343"
    }, delimiter = ',')
    @Order(2)
    void testCalculoVolumeCuboLista(double aresta, int expoente, double esperado) {

        double result = Math.pow(aresta, expoente);

        // aceita uma diferença de 0.0001 entre o valor esperado e o valor real
        assertEquals(esperado, result, 0.0001);
    }

    @ParameterizedTest
    //indica o caminho do arquivo queserá lido e seus delimitadores
    @CsvFileSource(resources = "/csv/massaVolumeCubo.csv", numLinesToSkip = 1, delimiter = ',')
    @Order(3)

    void testCalculoVolumeCuboCsv(String csvaresta, String csvexpoente, String resultadoesperado){

        double aresta = Double.parseDouble(csvaresta.substring(csvaresta.indexOf(":") + 1).trim());
        double expoente = Double.parseDouble(csvexpoente.substring(csvexpoente.indexOf(":") + 1).trim());
        double esperado = Double.parseDouble(resultadoesperado.substring(resultadoesperado.indexOf(":") + 1));

        double result = Math.pow(aresta, expoente);
        assertEquals(esperado, result, 0.0001);



    }
}


