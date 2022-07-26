package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {

    public static int solution(int n, int m, int[] line) {
        int answer = 0;
        int lt = Arrays.stream(line).max().getAsInt();
        int rt = Arrays.stream(line).sum();

        while (lt <= rt) {
            System.out.println("lt, rt = " + lt + ", " + rt);
            int mid = (lt + rt) / 2;
            if (count(line, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x <= capacity) {
                sum += x;
            } else {
                cnt++;
                sum = x;

            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(solution(n, m, arr));
    }
}
