package primeiroprojeto;
import java.util.Scanner;

public class casting {
    public static void main(String[] args) {
        Scanner inteiro = new Scanner(System.in);

        System.out.println("Escolha um número para ser convertido em Wrapper: ");
        int int1 = inteiro.nextInt();

        inteiro.close();

        Integer wrpr =  int1;
        System.out.println("Convertido: " + wrpr);
    }
}
