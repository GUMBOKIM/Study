package inflearn.DFSBFS;

import java.util.Scanner;

public class 조합_구하기 {

    static int n, m;
    static int[] check;

    public static void BFS(int L, int last) {
        if (L == m) {
            for (int i = 1; i <= n; i++) {
                if(check[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = last + 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    BFS(L + 1, i);
                    check[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new int[n + 1];

        BFS(0, 0);
    }
}
