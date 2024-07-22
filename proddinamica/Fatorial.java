import java.util.Scanner;

public class Fatorial {

  public static long calcularFatorial(int num){
    if(num == 0 || num == 1){
      return 1;
    }

    return num * calcularFatorial(num - 1);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Escolha um numero para calcular o fatorial: ");
    int num = s.nextInt();

    s.close();

    System.out.println("O fatorial de " + num + " eh " + calcularFatorial(num));
  }

  //Nao eh possível calcular o Fatorial de 100, pois exigiria muito gasto computacional, afinal 
  // o calculo fatorial é um valor que cresce exponencial.

}
