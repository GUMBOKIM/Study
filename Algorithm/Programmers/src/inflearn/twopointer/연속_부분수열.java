package inflearn.twopointer;

import java.util.Scanner;

public class 연속_부분수열 {

    public static int solution(int N, int M, int[] arr) {
        int answer = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            while (sum > M) {
                sum -= arr[start++];
            }
            if (sum == M) answer++;
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
