package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
                count++;
            }
        }

        if (count == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[count];
            count = 0;
            for (int num : list) {
                answer[count] = num;
                count++;
            }
            Arrays.sort(answer);
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] arr_arr = {
                {5, 9, 7, 10},
                {2, 36, 1, 3},
                {3, 2, 6}
        };

        int[] divisor_arr = {
                5,
                1,
                10
        };

        for (int i = 0; i < 3; i++) System.out.println(Arrays.toString(같은숫자는싫어.solution(arr_arr[i], divisor_arr[i])));
    }
}