package level1;

public class 음양더하기 {

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) answer += absolutes[i] * (signs[i] ? 1 : -1);
        return answer;
    }

    public static void main(String[] args) {
        int[][] absolutes_arr = {{4, 7, 12}, {1, 2, 3}};
        boolean[][] signs_arr = {{true, false, true}, {false, false, true}};
        for (int i = 0; i < 2; i++) {
            System.out.println(음양더하기.solution(absolutes_arr[i], signs_arr[i]));
        }
    }
}