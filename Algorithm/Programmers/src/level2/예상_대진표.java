package level2;

import java.util.Arrays;

public class 예상_대진표 {
    public static int solution(int n, int a, int b) {
        int answer = 0;
        int[] stage = new int[n];
        stage[a - 1] = 1;
        stage[b - 2] = 1;
        while(n != 1) {
            answer ++;
            int[] tempStage = new int[n / 2];
            for (int i = 0; i < n; i += 2) {
                int front = stage[i];
                int back = stage[i + 1];
                if(front == 1 && back == 1) return answer;
                else if(front == 1 || back == 1) tempStage[i/2] = 1;
            }
            stage = tempStage;
            n /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4 ,7));
    }
}
