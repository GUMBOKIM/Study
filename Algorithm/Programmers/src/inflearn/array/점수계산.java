package inflearn.array;

import java.util.Scanner;

public class 점수계산 {

    public static int solution(int[] arr) {
        int result = 0;
        int score = 0;
        for (int number : arr) {
            if (number == 0) {
                score = 0;
            } else {
                score++;
                result += score;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) arr[i] = sc.nextInt();
        System.out.println(solution(arr));
    }
}
