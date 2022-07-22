package inflearn.array;

import java.util.Scanner;

public class 보이는_학생 {

    public static int solution(int[] arr) {
        int count = 0;
        int max = 0;
        for (int now : arr) {
            if(now > max) {
                count++;
                max = now;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) arr[i] = sc.nextInt();

        System.out.print(solution(arr));
    }
}
