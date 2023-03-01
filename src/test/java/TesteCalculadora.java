// Bibliotecas
import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Classe
public class TesteCalculadora { // inicio da classe
    // Atributos

    // Funções e Métodos

    @Test
    public void testeSomarDoisNumeros(){ // inicio do teste do somar
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
    } // final do teste do somar

    @Test
    public void testeDividirDoisNumeros(){ //inicio do teste do dividir
        // Configura
        double num1 = 10;
        double num2 = 4;
        double resultadoEsperado = 2.5;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1,num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    } // final do teste do dividir

   @Test
    public void testeDividirDoisNumerosInteiros(){ // inicío do teste dividir inteiro
        // Configura
        int numA = 42;
        int numB = 6;
        String resultadoEsperado = "Não é possível dividir por zero";

        // Executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println("O resultado esperado: " + resultadoEsperado);
    } // fim do teste dividir inteiro
}
