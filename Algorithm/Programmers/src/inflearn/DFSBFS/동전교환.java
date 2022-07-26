package inflearn.DFSBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {

    static int n, m;
    static Integer[] coins;
    static int min = Integer.MAX_VALUE;

    static void DFS(int amount, int sum) {
        if (sum > m || amount > min) return;
        if (sum == m) {
            min = Math.min(min, amount);
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            DFS(amount + 1, sum + coins[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        m = sc.nextInt();
        DFS(0, 0);
        System.out.println(min);
    }
}
