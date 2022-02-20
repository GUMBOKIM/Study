package level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 정수제곱근판별 {

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt == Math.ceil(sqrt) ? (long) ((sqrt + 1) * (sqrt + 1)) : -1;


    }

    public static void main(String[] args) {
        long n = 11;

        System.out.println(정수제곱근판별.solution(n));
    }
}