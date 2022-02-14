package level1;


import java.util.Arrays;
import java.util.Stack;

public class 가장작은수제거하기 {

    public static int[] solution(int[] arr) {
        int length = arr.length;
        if(length == 1) return new int[]{-1};

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) if(min > arr[i]) min = arr[i];

        int[] answer = new int[length - 1];
        int idx = 0;
        for(int num : arr) {
            if(num != min) {
                answer[idx] = num;
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] n_r = {
                {4,3,2,1}	, {10}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(가장작은수제거하기.solution(n_r[i])));
        }
    }
}