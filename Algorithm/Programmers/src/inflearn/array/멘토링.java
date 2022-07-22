package inflearn.array;

import java.util.Scanner;

public class 멘토링 {
    static int[][] arr;
    static int n;
    static int m;

    public static int solution() {
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < n; l++) {
                        if(arr[k][l] == i) pi = l;
                        if(arr[k][l] == j) pj = l;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt == m) {
                    result ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution());
    }
}
