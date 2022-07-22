package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class 소수 {

    public static int solution(int length) {
        int answer = 0;

        int[] result = new int[length + 1];
        for (int i = 0; i < length + 1; i++) result [i] = 0;

        for (int i = 2; i < length + 1; i++) {
            int now = i;
            if(result[now] == 0) {
                answer ++;
                while (length >= now) {
                    result[now] = 1;
                    now += i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println(solution(length));
    }
}
