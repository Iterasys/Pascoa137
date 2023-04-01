package unitTest;
// bibliotecas necessarias para usar nos testes
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestVolumeCubo {

    @Test
    public void testCalcularVolumeCubo() {
        // Define a aresta do cubo
        double comprimentoAresta = 5.0;
        int potecia = 3;

        // Co cálculo do volume do cubo pode ser feito multiplicando o comprimento da aresta
        // por si mesma três vezes, ou seja, volume = comprimentoAresta * comprimentoAresta * comprimentoAresta.
        // Mas para simplificar o código e evitar repetições, é comum usar o método pow para calcular a potência
        // do número.
        double volumeCalculado = Math.pow(comprimentoAresta, potecia);

        // Define o resultado esperado
        double resultadoEsperado = 125.0;

        // Este código está usando o método "assertEquals" para verificar se o volume calculado de um
        // cubo está correto.
        //0.0001: a margem de erro permitida para a comparação dos valores esperado e calculado.
        assertEquals("O volume calculado do cubo deve ser " + resultadoEsperado + " unidades cúbicas",
                resultadoEsperado, volumeCalculado, 0.0001);

    }




}


