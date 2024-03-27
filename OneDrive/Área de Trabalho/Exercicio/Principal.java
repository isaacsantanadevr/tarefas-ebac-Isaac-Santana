package Exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        List<Pessoas> pessoas = new ArrayList<>();

        while (true) {
            String nome = JOptionPane.showInputDialog("Digite o nome:");
            if (nome == null || nome.isEmpty()) {
                break;
            }

            String sexo_palavra = JOptionPane.showInputDialog("Digite o sexo: [M/F]");
            if (sexo_palavra == null || sexo_palavra.isEmpty()) {
                break;
            }
            char sexo_letra = sexo_palavra.toUpperCase().charAt(0);

            if (sexo_letra != 'M' && sexo_letra != 'F') {
                JOptionPane.showMessageDialog(null, "Erro! Letra Errada", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            Pessoas pessoa = new Pessoas(nome, sexo_letra);
            pessoas.add(pessoa);

            List<Pessoas> people = pessoas.stream().filter(gen -> gen.getSexo() == 'F').collect(Collectors.toList());

            StringBuilder lista2 = new StringBuilder();

            for(Pessoas mulher : people){
                lista2.append("Nome: ").append(mulher.getNome()).append(", Sexo: ").append(mulher.getSexo()).append("\n");
            }

            int continuar = JOptionPane.showConfirmDialog(null, "Deseja adicionar outra pessoa?", "Continuar?", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, lista2.toString(), "Lista de Mulheres", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

        }

    }
}