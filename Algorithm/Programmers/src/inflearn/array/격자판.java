package inflearn.array;

import java.util.Scanner;

public class 격자판 {

    public static int solution(int n, int[][] arr) {
        int result = 0;

        // 세로
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + arr[i][j];
            }
            result = Math.max(result, sum);
        }

        // 가로
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + arr[j][i];
            }
        }
        
        // 대각선 \ 방향
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = arr[i][j];
            }
            result = Math.max(result, sum);
        }

        // 대각선 / 방향
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum = arr[i][j];
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
