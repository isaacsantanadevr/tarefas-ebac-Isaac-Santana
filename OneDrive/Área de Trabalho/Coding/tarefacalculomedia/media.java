package tarefacalculomedia;
import java.util.Scanner;

public class media{
    public static void main(String[] args) {
        Scanner notas = new Scanner(System.in);

        System.out.println("Digite a primeira nota:");
        double nota1 = notas.nextDouble();

        System.out.println("Digite a segunda nota:");
        double nota2 = notas.nextDouble();

        System.out.println("Digite a terceira nota:");
        double nota3 = notas.nextDouble();

        System.out.println("Digite a quarta nota:");
        double nota4 = notas.nextDouble();

        notas.close();

        double media = (nota1 + nota2 + nota3 + nota4)/4;

        System.out.println("A sua média é: " + media);
    }
}