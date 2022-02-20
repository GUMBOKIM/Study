package level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12944
public class 평균구하기 {

    public static double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};

        System.out.println(평균구하기.solution(a));
    }
}