package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class 큰_수_출력하기 {

    public static String solution(int length, int[] arr) {
        StringBuilder sb = new StringBuilder();
        int before = 0;
        for (int now : arr) {
            if(before < now) sb.append(now + " ");
            before = now;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) arr[i] = sc.nextInt();

        System.out.print(solution(length, arr));
    }
}
