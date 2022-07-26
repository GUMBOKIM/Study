package inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {

    public static int solution(int n, int[] coins, int total) {
        int[] results = new int[total + 1];
        Arrays.fill(results, Integer.MAX_VALUE);
        results[0] = 0;
        for (int i = 0; i <n; i++) {
            for (int j = coins[i]; j<= total; j++) {
                results[j] = Math.min(results[j], results[j - coins[i]] + 1);
            }
        }
        return results[total];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
        int total = sc.nextInt();
        System.out.print(solution(n, coins, total));
    }
}
