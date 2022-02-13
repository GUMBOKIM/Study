package level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        int n = nums.length / 2;
        Set<Integer> mon_set = new HashSet<>();
        for(int num : nums) mon_set.add(num);
        int answer = mon_set.size();
        return answer > n ? n : answer;
    }

    public static void main(String[] args) {
        int[][] nums_arr = {
                {3, 1, 2, 3},
                {3, 3, 3, 2, 2, 4},
                {3, 3, 3, 2, 2, 2}
        };


        for (int i = 0; i < 3; i++) {
            System.out.println(폰켓몬.solution(nums_arr[i]));
        }
    }
}