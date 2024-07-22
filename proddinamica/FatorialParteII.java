import java.util.HashMap;
import java.util.Map;

public class FatorialParteII {


    public static long fatorialTopDown(int n, Map<Integer, Long> memo) {
        if (n <= 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        long resultado = n * fatorialTopDown(n - 1, memo);
        memo.put(n, resultado);
        return resultado;
    }

    public static long fatorialBottomUp(int n) {
        if (n <= 1) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int numero = 7;
        Map<Integer, Long> memo = new HashMap<>();
        System.out.println("Fatorial de " + numero + " (Top-Down): " + fatorialTopDown(numero, memo));
        
        System.out.println("Fatorial de " + numero + " (Bottom-Up): " + fatorialBottomUp(numero));
        
        int numeroGrande = 100;
        System.out.println("Fatorial de " + numeroGrande + " (Bottom-Up): " + fatorialBottomUp(numeroGrande));
    }
}
