package inflearn.array;

import java.util.Scanner;

public class 등수구하기 {

    public static String solution(int length, int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int cnt = 1;
            for (int j = 0; j < length; j++) {
                if (arr[j] > arr[i]) cnt++;
            }
            sb.append(cnt + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) arr[i] = sc.nextInt();
        System.out.println(solution(length, arr));
    }
}
