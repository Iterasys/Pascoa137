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
    //Teste de unidade

    //Johnny Kamigashima

    @Test
    @DisplayName("Teste de volume de pirâmide triangular")
    @Order(1) //Executa em primeiro
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
    }, delimiter = ',') //O delimitador padrão é a vírgula
    @DisplayName("Teste de volume de pirâmide triangular parametrizado")
    @Order(2) //Executa em segundo
    void TesteParametrizado(String txtBase, String txtxAltura, String txtComprimento, String txtResultEsperado){

    //Configura
        double base = Double.parseDouble(txtBase); //Converte String base para Double base
        double altura = Double.parseDouble(txtxAltura); //Converte string altura para Double altura
        double comprimento = Double.parseDouble(txtComprimento); //Converte string comprimento para Double comprimento
        double resultadoEsperado = Double.parseDouble(txtResultEsperado); //Converte string resultadoEsperado para Double resultadoEsperado

    //Executa
        double resultado = Calculadora.volumePiramideTriangular(base, altura, comprimento); //Executa o método volumePiramideTriangular

    //Valida
        assertEquals(resultadoEsperado, resultado); //Valida se o resultado esperado é igual ao resultado
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/massaVolumePiramideTriangular.csv", numLinesToSkip = 1, delimiter = ',') //Lê o arquivo csv
    @DisplayName("Teste de volume de pirâmide triangular parametrizado com CSV")
    @Order(3) //Executa em terceiro
    void TesteParametrizadoCSV(String txtBase, String txtxAltura, String txtComprimento, String txtResultEsperado){
        //Configura
        double base = Double.parseDouble(txtBase); //Converte String base para Double base
        double altura = Double.parseDouble(txtxAltura); //Converte string altura para Double altura
        double comprimento = Double.parseDouble(txtComprimento); //Converte string comprimento para Double comprimento
        double resultadoEsperado = Double.parseDouble(txtResultEsperado); //Converte string resultadoEsperado para Double resultadoEsperado

        //Executa
        double resultado = Calculadora.volumePiramideTriangular(base, altura, comprimento);

        //Valida
        assertEquals(resultadoEsperado, resultado); //Valida se o resultado esperado é igual ao resultado
    }
}
