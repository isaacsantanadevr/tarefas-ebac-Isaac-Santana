import java.util.Arrays;

public class Troco {
    public static void main(String[] args) {
        int quantia = 18;
        int[] moedas = {5, 2, 1};
        int resultado = calculaMenorNumeroMoedas(quantia, moedas);
        System.out.println("Número mínimo de moedas necessárias: " + resultado);
      }

    public static int calculaMenorNumeroMoedas(int quantia, int[] moedas) {
        Arrays.sort(moedas);
        int numMoedas = 0;
        int valorRestante = quantia;

        for (int i = moedas.length - 1; i >= 0; i--) {
            while (valorRestante >= moedas[i]) {
                valorRestante -= moedas[i];
                numMoedas++;
            }
        }

        return numMoedas;
      }
}
