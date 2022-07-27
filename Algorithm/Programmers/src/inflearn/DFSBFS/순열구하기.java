package inflearn.DFSBFS;

import java.util.Scanner;

public class 순열구하기 {

    static int n, m;

    static int[] check;

    static void DFS(int L, int last) {
        if(L == m) print();
        else {
            for (int i = last; i <= n; i++) {
                check[i] ++;
                DFS(L + 1, i);
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
        DFS(0, 1);
    }
}
