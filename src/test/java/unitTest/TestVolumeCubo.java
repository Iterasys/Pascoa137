package unitTest;
// bibliotecas necessarias para usar nos testes
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestVolumeCubo {

    @Test
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

}


