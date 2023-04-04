package unitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static br.com.iterasys.Calculadora.areaCirculo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TesteAreaCirculo {
    @Test
    @DisplayName("Teste de area do circulo")
    void testeAreaCirculo() {
        //Configura
        double raio = 10;

        //Executa
        double resultado = areaCirculo(raio);

        //Valida
        assertEquals(314, resultado, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 314",
            "-15, 706.5",
            "30, 2826",
            "5.6, 98.4704",
            "50, 7850"
    })
    @DisplayName("Teste de area do circulo com Lista")
    void testeAreaCirculoLista(String  txtRaio, String txtResultadoEsperado) {
        //Configura
        double raio = Double.parseDouble(txtRaio);
        double resultadoEsperado = Double.parseDouble(txtResultadoEsperado);

        //Executa
        double resultado = areaCirculo(raio);

        //Valida
        assertEquals(resultadoEsperado, resultado,0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/areaCirculo.csv", numLinesToSkip = 1, delimiter = ';')
    void testeAreaCirculoCSV(String  txtRaio, String txtResultadoEsperado) {
        //Configura
        double raio = Double.parseDouble(txtRaio);
        double resultadoEsperado = Double.parseDouble(txtResultadoEsperado);

        //Executa
        double resultado = areaCirculo(raio);

        //Valida
        assertEquals(resultadoEsperado, resultado,0.01);
    }
}
