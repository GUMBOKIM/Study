package inflearn.DFSBFS;

import java.util.Scanner;

public class 섬나라아일랜드 {

    static int n, answer = 0;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    static void DFS(int row, int col) {
        map[row][col] = 0;
        for (int i = 0; i < 8; i++) {
            int crow = row + dy[i];
            int ccol = col + dx[i];
            if ((0 <= crow && crow < n) && (0 <= ccol && ccol < n) && map[crow][ccol] == 1) {
                DFS(crow, ccol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] == 1) {
                    answer++;
                    DFS(row, col);
                }
            }
        }
        System.out.println(answer);
    }

    static void print() {
        System.out.println("------- " + answer + " -----------");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }
}
