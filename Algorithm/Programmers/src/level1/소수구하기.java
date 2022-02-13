package level1;

public class 소수구하기 {

    public static int solution(int[] nums) {
        int answer = 0;

        int num_cnt = nums.length;
        for (int i = 0; i < num_cnt - 2; i++)
            for (int j = i+1; j < num_cnt - 1; j++) {
                for (int k = j+1; k < num_cnt; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int root = (int) Math.ceil(Math.sqrt(sum));
                    for(int a = 2; a <= root; a++){
                        if(sum % a == 0) break;
                        if(a == root) answer++;
                    }
                }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] nums_arr = {{1,2,3,4}, {1,2,7,6,4}};

        for (int i = 0; i < 2; i++) {
            System.out.println(소수구하기.solution(nums_arr[i]));
        }
    }
}