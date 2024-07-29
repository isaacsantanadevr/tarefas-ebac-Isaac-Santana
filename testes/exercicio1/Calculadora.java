package exercicio1;
public class Calculadora {
  public int adicionar(int a, int b){ //método que realiza a adição de dois números
    return a + b;
  }

  public int subtrair(int a, int b){//método que realiza a subtração de dois números
    return a - b;
  }

  public int multiplicar(int a, int b){//método que realiza a multiplicação de dois números
    return a * b;
  }

  public int dividir(int a, int b){//método que realiza a divisão de dois números
    if(b == 0){
      throw new ArithmeticException("Dividir por zero não é permitido!"); //caso o denominador seja 0, lança uma exceção
    }
    return a / b;
  }
}
