package inflearn.array;

import java.util.Scanner;

public class 피보나치 {

    public static String solution(int length) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if(i == 0 || i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i -1] + arr[i -2];
            }
            sb.append(arr[i] + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println(solution(length));
    }
}
