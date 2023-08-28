package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Nomes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Digite os nomes separados por vírgula:");
        String names = s.nextLine();

        String[] namesArray = names.split(",");
        List<String> nomes = new ArrayList<>();

        for (String nome : namesArray) {
            nomes.add(nome.trim());
        }

        Collections.sort(nomes);

        System.out.println("Nomes em ordem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        s.close();
    }
}

