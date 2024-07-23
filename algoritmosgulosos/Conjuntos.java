import java.util.ArrayList;
import java.util.List;

public class Conjuntos {
    public static void main(String[] args) {
      int[] S1 = {1, 2, 3};
      int n1 = 2;
      System.out.println("Subconjuntos de " + n1 + " elementos: " + gerarSubconjuntos(S1, n1));
      
      int[] S2 = {1, 2, 3, 4};
      int n2 = 1;
      System.out.println("Subconjuntos de " + n2 + " elementos: " + gerarSubconjuntos(S2, n2));
    }

  public static List<List<Integer>> gerarSubconjuntos(int[] S, int n) {
      List<List<Integer>> resultado = new ArrayList<>();
      backtrack(S, n, 0, new ArrayList<>(), resultado);
      return resultado;
    }

  private static void backtrack(int[] S, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
      if (atual.size() == n) {
          resultado.add(new ArrayList<>(atual));
          return;
      }

      for (int i = inicio; i < S.length; i++) {
          atual.add(S[i]);
          backtrack(S, n, i + 1, atual, resultado);
          atual.remove(atual.size() - 1);
      }
    }

}
