package inflearn.DFSBFS;

import java.util.Scanner;

public class 바둑이_승차 {

    static int c, n;
    static int[] arr;
    static int max = 0;
    static void DFS(int index, int sum) {
        if(sum > c) return;
        if(index == n - 1) {
            max = Math.max(max, sum);
        } else {
            DFS(index + 1, sum + arr[index + 1]);
            DFS(index + 1, sum);
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(-1, 0);
        System.out.println(max);
    }
}
