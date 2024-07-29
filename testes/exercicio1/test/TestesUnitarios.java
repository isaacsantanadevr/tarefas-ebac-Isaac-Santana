package exercicio1.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import exercicio1.Calculadora;

public class TestesUnitarios {

  /*Teste para o método de adicionar da classe calculadora
   * Verifica se a adição de dois números está correta
  */
  @Test
  public void adicionarTest(){
    Calculadora calc = new Calculadora();
    assertEquals(5, calc.adicionar(3, 2)); 
    //possui como resultado esperado o número da soma de 3 e 2 no método adicionar
    assertEquals(0, calc.adicionar(-1, 1));
    assertEquals(-8, calc.adicionar(-4, -4));
  }

  /*Teste para o método de subtrair da classe calculadora
   * Verifica se a subtração de dois números está correta
  */
  @Test
  public void subtrairTest(){
    Calculadora calc = new Calculadora();
    assertEquals(1, calc.subtrair(3, 2));
    //possui como resultado esperado o número da subtração de 3 e 2 no método subtrair
    assertEquals(-2, calc.subtrair(-1, 1));
    assertEquals(0, calc.subtrair(-4, -4));
  }

  /*Teste para o método de multiplicação da classe calculadora
   * Verifica se a multiplicação de dois números está correta
  */
  @Test
  public void multiplicarTest(){
    Calculadora calc = new Calculadora();
    assertEquals(6, calc.multiplicar(3, 2));
    //possui como resultado esperado o número do produto de 3 e 2 no método multiplicar
    assertEquals(-1, calc.multiplicar(-1, 1));
    assertEquals(16, calc.multiplicar(-4, -4));
  }

  /*Teste para o método de divisão da classe calculadora
   * Verifica se a divisão de dois números está correta
  */
  @Test
  public void dividirTest(){
    Calculadora calc = new Calculadora();
    assertEquals(3, calc.dividir(6, 2));
    //possui como resultado esperado o número da divisão de 6 e 2 no método dividir
    assertEquals(-1, calc.dividir(-3, 3));
    assertEquals(1, calc.dividir(-4, -4));

    Exception ex_div = assertThrows(ArithmeticException.class,() -> {
      calc.dividir(1, 0); //caso uma divisão por 0 seja feita, uma exceção é criada
    });

    assertEquals("Dividir por zero não é permitido!", ex_div.getMessage()); //retorna a mensagem esperada na exceção
  }
}
