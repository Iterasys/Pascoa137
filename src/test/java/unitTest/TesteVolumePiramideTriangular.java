package unitTest;

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TesteVolumePiramideTriangular {
    //Johnny Kamigashima

    @Test
    @DisplayName("Teste de volume de pirâmide triangular")
    @Order(1)
    void TesteSimples(){

    //Configura
        double base  = 5;
        double altura = 7;
        double comprimento = 3;
        double resultadoEsperado = 17.5;

    //Executa
        double resultado = Calculadora.volumePiramideTriangular(base, altura, comprimento);

    //Valida
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,7,3,17.5",
            "-15,8,3,-60",
            "5.5,-8,2.2,-16.133333333333336"
    }, delimiter = ',')
    @DisplayName("Teste de volume de pirâmide triangular parametrizado")
    @Order(2)
    void TesteParametrizado(String txtBase, String txtxAltura, String txtComprimento, String txtResultEsperado){

    //Configura
        double base = Double.parseDouble(txtBase);
        double altura = Double.parseDouble(txtxAltura);
        double comprimento = Double.parseDouble(txtComprimento);
        double resultadoEsperado = Double.parseDouble(txtResultEsperado);

    //Executa
        double resultado = Calculadora.volumePiramideTriangular(base, altura, comprimento);

    //Valida
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/massaVolumePiramideTriangular.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de volume de pirâmide triangular parametrizado com CSV")
    @Order(3)
    void TesteParametrizadoCSV(String txtBase, String txtxAltura, String txtComprimento, String txtResultEsperado){
        //Configura
        double base = Double.parseDouble(txtBase);
        double altura = Double.parseDouble(txtxAltura);
        double comprimento = Double.parseDouble(txtComprimento);
        double resultadoEsperado = Double.parseDouble(txtResultEsperado);

        //Executa
        double resultado = Calculadora.volumePiramideTriangular(base, altura, comprimento);

        //Valida
        assertEquals(resultadoEsperado, resultado);
    }
}
