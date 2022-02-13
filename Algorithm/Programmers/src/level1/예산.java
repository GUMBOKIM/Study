package level1;

import java.util.Arrays;

public class 예산 {

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            if (budget - d[i] >= 0) {
                answer++;
                budget -= d[i];
            } else break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] d_arr = {
                {1, 3, 2, 5, 4},
                {2, 2, 3, 3}
        };

        int[] budget_arr = {
                9,
                10
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(예산.solution(d_arr[i], budget_arr[i]));
        }
    }
}