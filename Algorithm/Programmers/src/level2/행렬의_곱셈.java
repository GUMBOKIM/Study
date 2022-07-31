package level2;

import java.util.Stack;

public class 행렬의_곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int center = arr1[0].length;
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < center; k++) sum += arr1[i][k] * arr2[k][j];
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }
}
