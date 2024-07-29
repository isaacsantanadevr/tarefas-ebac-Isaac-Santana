package exercicio2;

public class FibonacciRecursivo {
  public int seqFibonacci(int num){
    if(num == 0){
      return 0;
    }
    if(num == 1){
      return 1;
    }
    return seqFibonacci(num - 2) + seqFibonacci(num - 1);
  }
  public static void main(String[] args) {
    FibonacciRecursivo fib = new FibonacciRecursivo();
    int n = 9;

    int result = fib.seqFibonacci(n);

    System.out.println(result);
    
  }
}
