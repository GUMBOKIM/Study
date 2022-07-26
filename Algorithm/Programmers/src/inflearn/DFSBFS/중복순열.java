package inflearn.DFSBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 중복순열 {

    static int n, m;

    static int[] check;

    static void DFS(int L) {
        if(L == m) print();
        else {
            for (int i = 1; i <= n; i++) {
                check[i] ++;
                DFS(L + 1);
                check[i] --;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int count = check[i];
            for (int j = 0; j < count; j++) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        check = new int[n + 1];
        m = sc.nextInt();
        DFS(0);
    }
}
