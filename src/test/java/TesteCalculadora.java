// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe
public class TesteCalculadora {
    // Atributos

    // Funções e Métodos

    @Test
    public void testeSomarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
}
