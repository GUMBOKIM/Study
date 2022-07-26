package inflearn.dp;

import java.util.Scanner;

public class 돌다리_건너기 {

    public static int solution(int n) {
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(solution(n + 2));
    }
}
