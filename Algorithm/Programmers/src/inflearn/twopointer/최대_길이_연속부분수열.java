package inflearn.twopointer;

import java.util.Scanner;

public class 최대_길이_연속부분수열 {

    public static int solution(int N, int M, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt > M) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        System.out.print(solution(N, M, arr));
    }
}
