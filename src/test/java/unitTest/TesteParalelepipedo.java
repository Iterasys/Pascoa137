package unitTest;

// Bibliotecas
import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteParalelepipedo {

    @Test
    public void testeParalelepipedoSimples() {
        // Configura
        double base = 5;
        double altura = 6;
        double comprimento = 7;
        double resultadoEsperado = 210;

        // Executa
        double resultadoAtual = Calculadora.volumeParalelepipedo(base, altura, comprimento);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @ParameterizedTest  //  usando lista
    @CsvSource(value = {
            "2,3,4,24",
            "1,3,5,15",
            "4,5,3,60",
            "1,2,4,8",
            "2,2,2,8",
            "5,6,7,210",

    }, delimiter = ',')
    public void testeUsandoLista(double base, double altura, double comprimento, double resultadoEsperado) {
        // Executa
        double resultadoAtual = Calculadora.volumeParalelepipedo(base, altura, comprimento);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/massaVolume.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeLendoArquivoCsv(double base, double altura, double comprimento, double resultadoEsperado) {
        // Executa
        double resultadoAtual = Calculadora.volumeParalelepipedo(base, altura, comprimento);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }


}
