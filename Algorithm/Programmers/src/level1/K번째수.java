package level1;

import java.util.Arrays;

public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int length = commands.length;

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int[] command = commands[i];
            int start_idx = command[0] - 1;
            int end_idx = command[1] - 1;
            int size = end_idx - start_idx + 1;

            int[] split_arr = new int[size];
            for (int j = 0; j < size; j++) split_arr[j] = array[start_idx + j];
            Arrays.sort(split_arr);
            answer[i] = split_arr[command[2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] array_arr = {
                {1, 5, 2, 6, 3, 7, 4}
        };

        int[][][] commands_arr = {
                {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        };

        for (int i = 0; i < 1; i++) {
            System.out.println(Arrays.toString(K번째수.solution(array_arr[i], commands_arr[i])));
        }
    }
}