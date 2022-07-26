package inflearn.DFSBFS;

import java.util.Scanner;

public class 합이_같은_부분집합 {

    static int n, total = 0;
    static int[] arr;
    static boolean flag = false;
    static String answer = "NO";

    static void DFS(int L, int sum) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n) {
            if (total - sum == sum) {
                flag = true;
                answer = "YES";
            }
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0, arr[0]);
        System.out.println(answer);
    }
}
