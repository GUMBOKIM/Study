package level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 짝수와홀수 {

    public static String solution(int num) {
        return Math.abs(num % 2) == 1 ? "Odd" : "Even";
    }

    public static void main(String[] args) {
        int N = -1;
        int N2 = 10001;

        System.out.println(짝수와홀수.solution(N));
        System.out.println(짝수와홀수.solution(N2));
    }
}