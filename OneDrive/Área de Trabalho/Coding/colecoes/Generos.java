package colecoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nomesHomens = new ArrayList<>();
        List<String> nomesMulheres = new ArrayList<>();

        while (true) {
            System.out.println("Digite um nome seguido de '-M' para homem ou '-F' para mulher (ou 'sair' para encerrar):");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String nome = entrada.substring(0, entrada.length() - 2).trim();
            String genero = entrada.substring(entrada.length() - 2);

            if (genero.equalsIgnoreCase("-M")) {
                nomesHomens.add(nome);
            } else if (genero.equalsIgnoreCase("-F")) {
                nomesMulheres.add(nome);
            } else {
                System.out.println("Entrada inválida. Use '-M' para homem e '-F' para mulher.");
            }
        }

        System.out.println("Nomes de Homens:");
        for (String nome : nomesHomens) {
            System.out.println(nome);
        }

        System.out.println("\nNomes de Mulheres:");
        for (String nome : nomesMulheres) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
