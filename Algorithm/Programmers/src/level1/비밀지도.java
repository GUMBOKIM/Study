package level1;

import java.util.Arrays;

public class 비밀지도 {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int map1 = arr1[i];
            int map2 = arr2[i];
            StringBuilder sb = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                int pow = (int) Math.pow(2, j);
                if ((map1 / pow + map2 / pow) >= 1) sb.append("#");
                else sb.append(" ");
                map1 = map1 % pow;
                map2 = map2 % pow;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] n_arr = {
                5,
                6
        };
        int[][] arr1_arr = {
                {9, 20, 28, 18, 11},
                {46, 33, 33, 22, 31, 50}
        };

        int[][] arr2_arr = {
                {30, 1, 21, 17, 28},
                {27, 56, 19, 14, 14, 10}
        };
        for (int i = 0; i < 2; i++) System.out.println(Arrays.toString(비밀지도.solution(n_arr[i], arr1_arr[i], arr2_arr[i])));
    }
}