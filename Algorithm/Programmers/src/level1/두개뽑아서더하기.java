package level1;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {

    public static int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> answer_set = new HashSet<>();
        int length = numbers.length;
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length ; j++){
                answer_set.add(numbers[i] + numbers[j]);
            }
        }
        Integer[] answer_temp = answer_set.toArray(new Integer[0]);
        length = answer_temp.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) answer[i] = answer_temp[i];
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] numbers_arr = {
                {2,1,3,4,1},
                {5,0,2,7}
        };

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(두개뽑아서더하기.solution(numbers_arr[i])));
        }
    }
}