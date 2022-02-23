package skillcheck;

import java.util.Arrays;

public class level1_2 {

    public static int[] solution(int[] arr) {
        int length = arr.length;
        if(length == 1) return new int[]{-1};
        else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) min = Math.min(min, arr[i]);
            int[] answer = new int[length - 1];
            int idx = 0;
            for (int i = 0; i < length; i++){
                int temp = arr[i];
                if(temp != min) {
                    answer[idx] = arr[i];
                    idx ++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
    }
}
