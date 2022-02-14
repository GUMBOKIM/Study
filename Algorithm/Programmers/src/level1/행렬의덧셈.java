package level1;


import java.util.Arrays;

public class 행렬의덧셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][][] a_r = {
                {{1, 2}, {2, 3}}, {{1}, {2}}
        };
        int[][][] b_r = {
                {{3, 4}, {5, 6}}, {{3}, {4}}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(행렬의덧셈.solution(a_r[i], b_r[i])));
        }
    }
}