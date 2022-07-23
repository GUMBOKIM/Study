package inflearn.twopointer;

import java.util.Scanner;

public class 최대_매출 {


    public static int solution(int N, int M, int[] arr) {
//        int[] result = new int[N - M];
//
//        for (int i = 0; i < M; i++) result[0] += arr[i];
//        int first = arr[0];
//
//        for (int i = 1; i < N - M; i++) {
//            result[i] = result[i - 1] - first + arr[i - 1 + M];
//            first = arr[i];
//        }
//
//        int max = 0;
//        for (int i = 0; i < N - M; i++) max = Math.max(max, result[i]);
//
//        return max;
        int answer, sum = 0;
        for (int i = 0; i < M; i++) sum += arr[i];
        answer = sum;
        for (int i = M; i < N; i++) {
            sum += (arr[i] - arr[i - M]);
            answer = Math.max(answer, sum);
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
