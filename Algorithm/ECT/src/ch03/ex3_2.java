package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class ex3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int result = (m - (m / (k + 1))) * arr[n - 1] + (m / (k + 1)) * arr[n -2];

        System.out.println("result = " + result);
    }
}
