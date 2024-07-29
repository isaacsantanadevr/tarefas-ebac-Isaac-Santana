package exercicio2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exercicio2.FibonacciRecursivo;

public class FibonacciTest {
  
  @Test
  public void primeiroTest(){
    FibonacciRecursivo fibo = new FibonacciRecursivo();
    assertEquals(34, fibo.seqFibonacci(9));
  }

  @Test
  public void segundoTest(){
    FibonacciRecursivo fibo = new FibonacciRecursivo();
    assertEquals(0, fibo.seqFibonacci(0));
    assertEquals(1, fibo.seqFibonacci(1));
  }

  @Test
  public void terceiroTest(){
    FibonacciRecursivo fibo = new FibonacciRecursivo();
    boolean stackoverflow = false;
    try {
      fibo.seqFibonacci(50);
    } catch (StackOverflowError e) {
      stackoverflow = true;
    }

    assertTrue("StackOverflowError should have occurred", stackoverflow);
  }
}
